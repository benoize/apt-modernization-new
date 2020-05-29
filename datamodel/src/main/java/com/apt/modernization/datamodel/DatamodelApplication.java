package com.apt.modernization.datamodel;

import com.apt.modernization.datamodel.dataservices.DataTransform;
import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.repository.QuotesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
public class DatamodelApplication {



	public static void main(String[] args) {
		SpringApplication.run(DatamodelApplication.class, args);
        }

}
