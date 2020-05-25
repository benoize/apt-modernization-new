package com.apt.modernization.datamodel.dataServices;

import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.repository.QuotesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableMongoRepositories(basePackageClasses = QuotesRepository.class)
public class DataTransform {

    private QuotesRepository quotesRepository;
    private List<Quotes> quotesList;


    public DataTransform(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
        printList();
    }

    private void printList() {
        quotesList = quotesRepository.findAll();
        for (Quotes quotes : quotesList) {
            System.out.println(quotes.getQuote_id() + ", " +
                    quotes.getInsured_name() + ", " +
                    quotes.getIncept_date() + ", " +
                    quotes.getExpiry_date() + ", " +
                    quotes.getCurrency());
        }
    }
}
