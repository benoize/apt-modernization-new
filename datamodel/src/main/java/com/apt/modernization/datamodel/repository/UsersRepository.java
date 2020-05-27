package com.apt.modernization.datamodel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apt.modernization.datamodel.document.Users;

public interface UsersRepository extends MongoRepository<Users,Long> {
	Users findById(long id);
}
