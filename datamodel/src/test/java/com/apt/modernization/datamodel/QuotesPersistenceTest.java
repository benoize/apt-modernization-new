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
public class QuotesPersistenceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(QuotesPersistenceTest.class);

	private static final int AMOUNT_MULTIPLE_INSERT=10000;
	
	private static final int ID_BASIC_PERSISTENCE=1;
	
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
		
		LOG.debug("Finished basic persistence-Tests.");
	}
	
	
	@Test
	public void testMultipleInserts() {
		removeAllQuoteDocuments();
		
		StringBuilder stringBuilder=new StringBuilder();

		LOG.debug("Start persisting "+AMOUNT_MULTIPLE_INSERT+" Quotes....");
		Interval interval=new Interval();
		for (int i=0;i<AMOUNT_MULTIPLE_INSERT;i++) {
			stringBuilder.setLength(0);
			stringBuilder.append("name-");
			stringBuilder.append(i);
			String insured=stringBuilder.toString();
			
			stringBuilder.setLength(0);
			stringBuilder.append("incept-");
			stringBuilder.append(i);
			String incept=stringBuilder.toString();
			
			stringBuilder.setLength(0);
			stringBuilder.append("expiry-");
			stringBuilder.append(i);
			String expiry=stringBuilder.toString();
			
			stringBuilder.setLength(0);
			stringBuilder.append("currency-");
			stringBuilder.append(i);
			String currency=stringBuilder.toString();
			
			Quotes quote=new Quotes(i, insured, incept, expiry, currency);
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
	
	//
	// Nested classes
	//
	private static class Interval {
		private static final Logger LOG = LoggerFactory.getLogger(Interval.class);
		private static final long INTERVAL_INVALID=-1;
		
		private long start=INTERVAL_INVALID;
		private long end=INTERVAL_INVALID;
		
		public Interval() {
			start();
		}
		
		public void start() {
			start=System.currentTimeMillis();
			end=INTERVAL_INVALID;
		}
		
		public void stop() {
			if (start==INTERVAL_INVALID) {
				LOG.warn("Timng stopped without start. Forcing start resulting in a 0-interval.");
				start();
			}
			end=System.currentTimeMillis();
		}
		
		public long getInterval() {
			long result=INTERVAL_INVALID;
			if ((start!=INTERVAL_INVALID) && (end!=INTERVAL_INVALID))
			{
				result=end-start;
			}
			return result;
		}
		
		@Override
		public String toString() {
			return String.valueOf(getInterval());
		}
		
	}
}
