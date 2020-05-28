package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quotes")
public class Quotes {

    @Id
    private Long quoteId;
    
    private String insuredName;
    private String inceptDate;
    private String expiryDate;
    private String currency;

    public Quotes(long quoteId) {
        this.quoteId = Long.valueOf(quoteId);
    }

    public Long getQuoteId() {
        return quoteId;
    }
    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }
    public String getInsuredName() {
        return insuredName;
    }
    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }
    public String getInceptDate() {
        return inceptDate;
    }
    public void setInceptDate(String inceptDate) {
        this.inceptDate = inceptDate;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
