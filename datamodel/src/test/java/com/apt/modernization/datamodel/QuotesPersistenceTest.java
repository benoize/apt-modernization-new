package com.apt.modernization.datamodel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.repository.QuotesRepository;

@SpringBootTest
public class QuotesPersistenceTest extends PersistenceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(QuotesPersistenceTest.class);

	private static final int AMOUNT_MULTIPLE_INSERT=10000;
	
	private static final long ID_BASIC_PERSISTENCE=1;
	
	@Autowired
	private QuotesRepository quotesRepository;

	@Test
	public void testBasicQuotePersistence() {
		LOG.debug("Starting basic persistence-Tests...");
		assertNotNull(quotesRepository, "Unexpected: local quotesRepository is null");

		// Check and delete perhaps existing persistent
		Quotes existing=quotesRepository.findById(ID_BASIC_PERSISTENCE);
		if (existing!=null) {
			quotesRepository.delete(existing);
		}
		existing=quotesRepository.findById(ID_BASIC_PERSISTENCE);
		assertNull(existing, "Test persistence ID already exists and cant be deleted.");
		
		// Create new persistent and ...
		Quotes newQuotes=new Quotes(ID_BASIC_PERSISTENCE, "BASIC_PERSISTENCE", "BASIC_PERSISTENCE_DATE_1", "BASIC_PERSISTENCE_DATE_2", "CURRENCY");
		quotesRepository.save(newQuotes);
		
		// check existence.
		Quotes readQuotes=quotesRepository.findById(ID_BASIC_PERSISTENCE);
		assertNotNull(readQuotes,"Could not persist new object.");
		
		Quotes byInceptDate=quotesRepository.findByInceptDate("BASIC_PERSISTENCE_DATE_1");
		assertNotNull(byInceptDate,"Could not find new object by InceptDate.");
		
		LOG.debug("Finished basic persistence-Tests.");
	}
	
	
	@Test
	public void testMultipleInserts() {
		removeAllQuoteDocuments();
		
		StringBuilder stringBuilder=new StringBuilder();

		LOG.debug("Start persisting "+AMOUNT_MULTIPLE_INSERT+" Quotes....");
		Interval interval=new Interval();
		for (int i=0;i<AMOUNT_MULTIPLE_INSERT;i++) {
			Quotes quote=buildSampleQuotes(i, stringBuilder);
			quotesRepository.save(quote);
		}
		interval.stop();
		LOG.debug("Finished persisting "+AMOUNT_MULTIPLE_INSERT+" Quotes. Took "+interval+"ms.");
	}
	
	//
	// Utils
	//
	private void removeAllQuoteDocuments() {
		LOG.debug("Removing Quotes-Documents...");
		Interval interval=new Interval();
		List<Quotes> quotesList=quotesRepository.findAll();
		for (Quotes quotes:quotesList) {
			quotesRepository.delete(quotes);
		}
		interval.stop();
		LOG.debug("Quotes-Documents are empty now. Took "+interval.getInterval()+"ms.");
	}
}
