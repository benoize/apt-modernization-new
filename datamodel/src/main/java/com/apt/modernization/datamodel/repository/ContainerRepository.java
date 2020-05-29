package com.apt.modernization.datamodel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apt.modernization.datamodel.document.Container;

public interface ContainerRepository  extends MongoRepository<Container, Long> {
	Container findById(long id);
}
