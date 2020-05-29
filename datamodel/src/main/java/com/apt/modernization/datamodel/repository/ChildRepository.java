package com.apt.modernization.datamodel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apt.modernization.datamodel.document.Child;

public interface ChildRepository extends MongoRepository<Child, Long> {
	Child findById(long id);
}
