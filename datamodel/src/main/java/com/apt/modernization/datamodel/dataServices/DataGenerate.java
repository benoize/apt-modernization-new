package com.apt.modernization.datamodel.dataServices;

import com.apt.modernization.datamodel.document.*;
import com.apt.modernization.datamodel.repository.QuotesRepository;
import com.apt.modernization.datamodel.repository.UsersRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

//@Service
//@Component
@EnableMongoRepositories(basePackageClasses = QuotesRepository.class)
public class DataGenerate {

    private QuotesRepository quotesRepository;
    private UsersRepository usersRepository;
    private List<Quote> quoteList;
    private Quote quote;
    private Long lng;
    private List<CoverageComponent> coverageComponents;
    private CoverageComponent coverageComponent;
    private InsuredEntitiy insuredEntitiy;
    private CoverageComponentConfiguration coverageComponentConfiguration;
    private Integer coverageComponentIterator;
    private PremiumCoverageComponent premiumCoverageComponent;

    private List<String> countryArray;
    Random rnd;



    public DataGenerate(QuotesRepository quotesRepository,
                        UsersRepository usersRepository) {
        this.quotesRepository = quotesRepository;
        //this.usersRepository = usersRepository;
        //printList();
        //quotesRepository.deleteAll();
        //AddCollections();
    }


    private void AddCollections() {
        countryArray = new ArrayList<String>();
        //quoteList = new ArrayList<Quote>();
        lng = Long.valueOf(10000000);
        for(int cnt=1;cnt<100000;cnt++){
            lng++;
            quote = new Quote();
            loadQuoteData();
            //System.out.println("Qoute " + quote.getQuoteId());
            quotesRepository.save(quote);
        }

        /*
        quotesListId = new ArrayList<Long>();
        Quote quote = new Quote();
        quoteList.add(quote);
        quotesRepository.save(quote);
        quotesListId.add(quote.getQuoteId());
        quote = new Quote();
        quoteList.add(quote);
        quotesRepository.save(quote);
        quotesListId.add(quote.getQuoteId());
        Users user = new Users((long) 16,"", "Cliff", "bj_cliff@gmail.com", quotesListId);
        usersRepository.save(user);

        quoteList = new ArrayList<Quote>();
        quote = new Quote();
        quoteList.add(quote);
        quotesRepository.save(quote);
        quotesListId.add(quote.getQuoteId());
        user = new Users((long) 86,"Benoit", "Debrock", "benoize@gmail.com", quotesListId);
        usersRepository.save(user);
        */
    }

    private void printList() {

        //usersList = usersRepository.findAll();

        //usersList.forEach(System.out::println);
    }

    private void loadQuoteData(){
        quote.setQuoteId(lng);
        quote.setName("UK_"+ Long.toString(lng));
        quote.setDescription("APT quote for Liability test");

        quote.setInsuredComapnyName("Man Group UK");
        quote.setInsuredCountryOfResidence("United Kingdom");
        quote.setInsuredTypeOfCompany("LLC");
        quote.setInsuredComapnyName("LOE");
        quote.setCountryCurrency("GBP");

        quote.setUnderwriter("Ed McCandless");
        quote.setUnderwriter("McCandless.Ed@allianz.com");
        quote.setInceptionDate("01-01-2020");
        quote.setExpiryDate("31-12-2020");
        quote.setPolicyDurationAmount("365");
        quote.setPolicyDurationAmount("days");

        quote.setQuoteReferenceNumber(RandomStringUtils.randomAlphabetic(8));
        quote.setClientReferenceNumber(quote.getQuoteReferenceNumber()+"_1");
        quote.setCurrency("EUR");
        quote.setRateOfExchange(1.1);
        coverageComponents = new ArrayList<CoverageComponent>();

        addCountriesToArray();
        for(int i = 1 ; i <= 11; i++){
            coverageComponentIterator = Integer.valueOf(i);
            loadInsuredEntityData();
            loadCoverageComponentConfigurationData();
            loadPremiumCoverageComponent();
            loadCoverageComponentData();

            coverageComponents.add(coverageComponent);
        }
        quote.setCoverageComponents(coverageComponents);
    }


    private void addCountriesToArray() {
        countryArray.add("United Kingdom");
        countryArray.add("Australia");
        countryArray.add("Canada");
        countryArray.add("China");
        countryArray.add("New Zealand");
        countryArray.add("France");
        countryArray.add("Germany");
        countryArray.add("The Netherlands");
        countryArray.add("Guam");
        countryArray.add("Ireland");
        countryArray.add("Italy");

    }

    private void loadCoverageComponentData(){
        //create new object
        coverageComponent = new CoverageComponent();

        coverageComponent.setId(Long.valueOf(coverageComponentIterator));
        coverageComponent.setName("CoverageComponent_" + countryArray.get(coverageComponentIterator-1));
        coverageComponent.setDescription("The coverage component for " + countryArray.get(coverageComponentIterator-1));

        coverageComponent.setInsuredEntitiy(insuredEntitiy);
        coverageComponent.setCoverageComponentConfiguration(coverageComponentConfiguration);
        coverageComponent.setPremiumCoverageComponent(premiumCoverageComponent);
    }

    private void loadInsuredEntityData(){
        //create new object
        insuredEntitiy = new InsuredEntitiy();

        rnd = new Random();
        int n = 100000000 + rnd.nextInt(900000000);
        insuredEntitiy.setId(Long.valueOf(coverageComponentIterator));
        insuredEntitiy.setName("Insured_Entity_" + countryArray.get(coverageComponentIterator-1));
        insuredEntitiy.setDescription("insured Entity " + countryArray.get(coverageComponentIterator-1));

        insuredEntitiy.setInsureableEntityName("Country");
        insuredEntitiy.setInsureableEntityCategoryId("1");
        insuredEntitiy.setInsureableEntityExposureMeasureId("1");
        insuredEntitiy.setInsureableEntityExposureMeasureName("Turnover");
        insuredEntitiy.setInsureableEntityExposureMeasureAmount(Double.valueOf(n));
        insuredEntitiy.setInsureableEntityExposureMeasureCurrency("EUR");
    }

    private void loadCoverageComponentConfigurationData(){
        //create new object
        coverageComponentConfiguration = new CoverageComponentConfiguration();

        coverageComponentConfiguration.setId(Long.valueOf(coverageComponentIterator));
        coverageComponentConfiguration.setName("Configurator_" + coverageComponentIterator);
        coverageComponentConfiguration.setDescription("Configurator for coverage component " + coverageComponentIterator);
        rnd = new Random();
        int n = 1 + rnd.nextInt(9);
        //System.out.println(n);
        coverageComponentConfiguration.setLimitAggregation( n <= 5 ? true : false);
        rnd = new Random();
        n = 100000 + rnd.nextInt(900000);
        coverageComponentConfiguration.setRetention(Double.valueOf(n));
        rnd = new Random();
        n = 10000000 + rnd.nextInt(90000000);
        coverageComponentConfiguration.setLimitAmount(Double.valueOf(coverageComponentConfiguration.getLimitAggregation() ? n *10 : n));

    }

    private void loadPremiumCoverageComponent() {
        //create new object
        premiumCoverageComponent = new PremiumCoverageComponent(0.0);
    }


}
