package com.apt.modernization.datamodel.resource;

import com.apt.modernization.datamodel.document.Quote;
import com.apt.modernization.datamodel.repository.QuotesRepository;

import java.util.List;

public class QuotesRescource {

    private QuotesRepository quotesRepository;

    public QuotesRescource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    public List<Quote> getAll(){
        return quotesRepository.findAll();
    }
}
