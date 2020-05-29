package com.apt.modernization.datamodel.dataservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.repository.QuotesRepository;

@Component
@EnableMongoRepositories(basePackageClasses = QuotesRepository.class)
public class DataTransform {
	private static final Logger LOG = LoggerFactory.getLogger(DataTransform.class);

    private QuotesRepository quotesRepository;
    private List<Quotes> quotesList;


    public DataTransform(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
        printList();
    }

    private void printList() {
        quotesList = quotesRepository.findAll();
        for (Quotes quotes : quotesList) {
            LOG.trace("{}, {}, {}, {}, {}",quotes.getQuoteId(),quotes.getInsuredName(),quotes.getInceptDate(),quotes.getExpiryDate() ,quotes.getCurrency());
        }
    }
}