package com.apt.modernization.datamodel.repository;

import com.apt.modernization.datamodel.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users,Integer> {
}
