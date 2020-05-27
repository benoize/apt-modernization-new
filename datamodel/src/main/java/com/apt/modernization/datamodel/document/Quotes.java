package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Document(collection = "quotes")
public class Quotes {

    @Id
    private Long quoteId;
    private String insuredName;
    private String inceptDate;
    private String expiryDate;
    private String currency;

    public Quotes(Long quoteId, String insuredName, String inceptDate, String expiryDate, String currency) {
        this.quoteId = quoteId;
        this.insuredName = insuredName;
        this.inceptDate = inceptDate;
        this.expiryDate = expiryDate;
        this.currency = currency;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quote_id) {
        this.quoteId = quote_id;
    }

    public String getInsured_name() {
        return insuredName;
    }

    public void setInsured_name(String insured_name) {
        this.insuredName = insured_name;
    }

    public String getIncept_date() {
        return inceptDate;
    }

    public void setIncept_date(String incept_date) {
        this.inceptDate = incept_date;
    }

    public String getExpiry_date() {
        return expiryDate;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiryDate = expiry_date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
