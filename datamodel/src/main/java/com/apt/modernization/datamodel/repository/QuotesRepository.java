package com.apt.modernization.datamodel.repository;

import com.apt.modernization.datamodel.document.Quotes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuotesRepository extends MongoRepository<Quotes, Long> {
	Quotes findById(long id);
	Quotes findByInceptDate(String inceptDate);
}
