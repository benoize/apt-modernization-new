package com.apt.modernization.datamodel.config;

import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.repository.QuotesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
public class MongoDBConfig {

/*
    @Bean
    CommandLineRunner commandLineRunner(QuotesRepository quotesRepository){
        return Strings -> {
            quotesRepository.save(new Quotes(1, "Man Group", "01-01-2020", "31-12-2020", "USD"));
            quotesRepository.save(new Quotes(2, "Royal Shell", "01-02-2020", "31-01-2021", "USD"));
        };
    }

 */
}
