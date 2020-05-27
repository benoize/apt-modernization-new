package com.apt.modernization.datamodel.dataServices;

import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.document.Users;
import com.apt.modernization.datamodel.repository.QuotesRepository;
import com.apt.modernization.datamodel.repository.UsersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@EnableMongoRepositories(basePackageClasses = QuotesRepository.class)
public class DataTransform {

    private QuotesRepository quotesRepository;
    private UsersRepository usersRepository;
    private List<Quotes> quotesList;
    private List<Users> usersList;
    private List<Long> quotesListId;


    public DataTransform(QuotesRepository quotesRepository,
                        UsersRepository usersRepository) {
        this.quotesRepository = quotesRepository;
        this.usersRepository = usersRepository;
        printList();
        //AddCollections();
    }


    private void AddCollections() {
        quotesList = new ArrayList<Quotes>();
        quotesListId = new ArrayList<Long>();
        Quotes quote = new Quotes( (long)10, "Royal Shell", "20-02-2020", "19-02-2021","Euro");
        quotesList.add(quote);
        quotesRepository.save(quote);
        quotesListId.add(quote.getQuoteId());
        quote = new Quotes( (long)12, "Tesla", "20-02-2020", "19-02-2021","USD");
        quotesList.add(quote);
        quotesRepository.save(quote);
        quotesListId.add(quote.getQuoteId());
        Users user = new Users((long) 16,"", "Cliff", "bj_cliff@gmail.com", quotesListId);
        usersRepository.save(user);

        quotesList = new ArrayList<Quotes>();
        quote = new Quotes( (long)13, "KLM", "20-02-2020", "19-02-2021","Euro");
        quotesList.add(quote);
        quotesRepository.save(quote);
        quotesListId.add(quote.getQuoteId());
        user = new Users((long) 86,"Benoit", "Debrock", "benoize@gmail.com", quotesListId);
        usersRepository.save(user);
    }

    private void printList() {

        usersList = usersRepository.findAll();

        usersList.forEach(System.out::println);
    }
}
