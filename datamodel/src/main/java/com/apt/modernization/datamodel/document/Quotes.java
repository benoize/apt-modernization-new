package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quotes")
public class Quotes {

    @Id
    private Integer quote_id;
    private String insured_name;
    private String incept_date;
    private String expiry_date;
    private String currency;

    public Quotes(Integer quote_id, String insured_name, String incept_date, String expiry_date, String currency) {
        this.quote_id = quote_id;
        this.insured_name = insured_name;
        this.incept_date = incept_date;
        this.expiry_date = expiry_date;
        this.currency = currency;
    }

    public Integer getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(Integer quote_id) {
        this.quote_id = quote_id;
    }

    public String getInsured_name() {
        return insured_name;
    }

    public void setInsured_name(String insured_name) {
        this.insured_name = insured_name;
    }

    public String getIncept_date() {
        return incept_date;
    }

    public void setIncept_date(String incept_date) {
        this.incept_date = incept_date;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
