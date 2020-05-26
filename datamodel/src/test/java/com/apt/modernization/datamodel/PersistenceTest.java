package com.apt.modernization.datamodel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.repository.QuotesRepository;

@SpringBootTest
public class PersistenceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(PersistenceTest.class);
	
	private static final int ID_BASIC_PERSISTENCE=1;
	
	@Autowired
	private QuotesRepository quotesRepository;
	
	@Test
	public void testBasicQuotePersistence() {
		LOG.debug("Starting basic persistence-Tests...");
		assertNotNull(quotesRepository, "Unexpected: local quotesRepository is null");

		// Check and delete probably existing persistent
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
}
