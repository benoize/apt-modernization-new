package com.apt.modernization.datamodel.repository;

import com.apt.modernization.datamodel.document.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuotesRepository extends MongoRepository<Quote, Integer> {
}
