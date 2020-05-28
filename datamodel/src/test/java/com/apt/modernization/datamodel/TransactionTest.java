package com.apt.modernization.datamodel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.repository.QuotesRepository;

/*
 *   
 * MongoDB-Cluster must run in 'replica-set'-mode to get this working.
 *   Start MongoDB using the commandLine-option '--replSet rs0',
 *   then initially connect to DB using 'mongo.exe' and run 'rs.initiate()'. (really in console by just typin....)
 *   When doin this in my case, got some further leading command-prompts which I just
 *   confirmed with [enter] or finally even just closed.
 *   
 * When DB not in replica-set-mode, you will receive
 * 'com.mongodb.MongoClientException: Sessions are not supported by the MongoDB cluster to which this client is connected'
 * Currently detailed impact in/on mongo-DB is unknown.
 * 
 * Also remember mongo-client needs the presence of a TransactionManager. This is not present by default.
 * So MongoDBConfig-Class provides TransactionManager-class-def: MongoTransactionManager 
 * 
 * Some general thoughts:
 * 'Operation' serves as a callback to run anything(!) in an transactional context, will be implemented as an anonymous 
 *   class and passed to a generic transactional component.
 * 'TransactionalComponent' is a generic transactional component, only calling passed 'operation'-interface,
 *   then in transactional context.
 *
 * Test here simply tests succeeding/failing transaction. Object-visibilities aren't fully tested.
 * 
 */
@SpringBootTest
@ComponentScan					// needed to autowire nested/inner classes
@ImportAutoConfiguration		// needed to autowire nested/inner classes
public class TransactionTest extends PersistenceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(TransactionTest.class);
	private static final long ID_BASIC_PERSISTENCE=1;

	@Autowired
	private QuotesRepository quotesRepository;
	@Autowired
	private TransactionalComponent transactionalComponent;

	@Test
	public void testFailingTransaction() {
		LOG.debug("Starting failing transaction-Test...");
		assertNotNull(quotesRepository, "Unexpected: local quotesRepository is null");
		assertNotNull(transactionalComponent, "Unexpected: local transactionalComponent is null");
		resetTestEcosystem();
		
		Operation operation=new Operation() {
			public void operate() throws RollbackException {
				Quotes newQuotes=buildSampleQuotes(ID_BASIC_PERSISTENCE, null);
				quotesRepository.save(newQuotes);
				throw new RollbackException();
			}
		};
		
		Exception expected=null;
		try {
			transactionalComponent.operate(operation);
		} catch (Exception e) {
			expected=e;
		}
		assertNotNull(expected, "Expected Exception not thrown." );
		assertTrue(expected instanceof RollbackException, "Unexpected ExceptionType.");

		// check existence.
		Quotes readQuotes=quotesRepository.findById(ID_BASIC_PERSISTENCE);
		assertNull(readQuotes,"Failed transaction lead to persisted object.");
		
		LOG.debug("Finished failing transaction-Test.");
	}
	
	@Test
	public void testSucceedingTransaction() {
		LOG.debug("Starting succeeding transaction-Test...");
		assertNotNull(quotesRepository, "Unexpected: local quotesRepository is null");
		assertNotNull(transactionalComponent, "Unexpected: local transactionalComponent is null");
		resetTestEcosystem();
		
		Operation operation=new Operation() {
			public void operate() throws RollbackException {
				Quotes newQuotes=buildSampleQuotes(ID_BASIC_PERSISTENCE, null);
				quotesRepository.save(newQuotes);
			}
		};
		
		Exception expected=null;
		try {
			transactionalComponent.operate(operation);
		} catch (Exception e) {
			expected=e;
		}
		assertNull(expected, "Unexpected Exception thrown." );

		// check existence.
		Quotes readQuotes=quotesRepository.findById(ID_BASIC_PERSISTENCE);
		assertNotNull(readQuotes,"Succeeding transaction doesn't lead to persisted object.");
		
		LOG.debug("Finished succeeding transaction-Test.");
	}

	@Test
	public void testInstanceVisibilities() {
		// Not really rock-solid, but OK........
		LOG.debug("Start testing visibilities...");
		assertNotNull(quotesRepository, "Unexpected: local quotesRepository is null");
		assertNotNull(transactionalComponent, "Unexpected: local transactionalComponent is null");
		resetTestEcosystem();
		final Thread mainThread=Thread.currentThread();

		// Immediately creates new Quotes, saves them, but
		// then sleeps before committing.
		Operation threadOperation=new Operation() { 
			public void operate() throws RollbackException {
				Quotes newQuotes=buildSampleQuotes(ID_BASIC_PERSISTENCE, null);
				quotesRepository.save(newQuotes);
				LOG.debug("Saved new Quotes inside transaction. Waiting for getting externally waked up.");
				mainThread.interrupt(); // (A); Wake up MainThread which should be sleeping at this point
				silentSleep(60000); // Sleeping 60secs. (or getting awaked externally....) before committing.
				                    // Wait for (B)
				LOG.debug("Woke up! Committing.");
				// Will be committed after exit - so object should be visible earliest after 5 sec.
			}
		};

		// SpinOff to launch previous operation transactionally......
		Thread threadOne=new Thread() {
			@Override
			public void run() {
				try {
					transactionalComponent.operate(threadOperation);
				} catch (RollbackException e) {
					LOG.warn("Ignoring RollbackException.",e);
				}
				mainThread.interrupt(); // (C); Wake up MainThread which should be sleeping at this point
			}
		};
		threadOne.start();
		silentSleep(60000); // Waiting for getting waked up after save of newQuotes but not committed.
		                    // Wait for (A)
		
		LOG.debug("Checking object existence after transactional save....");
		Quotes beforeFiveSecs=quotesRepository.findById(ID_BASIC_PERSISTENCE);
		assertNull(beforeFiveSecs,"Found Object before transaction commit.");
		LOG.debug("Checked object existence after transactional save/before commit. OK. (Doesnt exist)");

		threadOne.interrupt(); // (B); Wake up threadOne which should be sleeping at this point.
		silentSleep(60000); // threadOne now needs some time to commit (Will get awaken after 
		                    // threadOne leaves transactional section)
		                    // Wait for (C)
		
		LOG.debug("Checking object existence after transaction commit....");
		Quotes afterFiveSecs=quotesRepository.findById(ID_BASIC_PERSISTENCE);
		assertNotNull(afterFiveSecs,"Did not find Object after transaction commit.");
		LOG.debug("Checking object existence after transaction commit. OK. (Exists)");
	}
	
	//
	// Privates
	//
	private void resetTestEcosystem() {
		// Check and delete perhaps existing persistent
		Quotes existing=quotesRepository.findById(ID_BASIC_PERSISTENCE);
		if (existing!=null) {
			quotesRepository.delete(existing);
		}
		existing=quotesRepository.findById(ID_BASIC_PERSISTENCE);
		assertNull(existing, "Test persistence ID already exists and cant be deleted.");
	}
	
	private void silentSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			LOG.trace("Caught InterruptedException durin sleep - ignoring",e);
		}
	}
	
	//
	// Nested stuff
	//
	@Component
	@Transactional(rollbackFor = RollbackException.class)
	public static class TransactionalComponent {
		public void operate(Operation callback) throws RollbackException {
			callback.operate();
		}
	}
	
	public static interface Operation {
		public void operate() throws RollbackException;
	}
	public static class RollbackException extends Exception {
		private static final long serialVersionUID = 1L;
	}
}
