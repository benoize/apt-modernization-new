package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Document(collection = "quotes")
public class Quote {

    @Id
    private Long quoteId;
    private String name;
    private String description;

    private String insuredComapnyName;
    private String insuredCountryOfResidence;
    private String usaTerritory;
    private String usaState;
    private String insuredTypeOfCompany;
    private String insuredLeadOperationalEntity;
    private String countryCurrency;

    private String underwriter;
    private String underwriterEmail;

    private String inceptionDate;
    private String expiryDate;
    private String policyDurationAmount;
    private String policyDurationUnit;
    private String endorsementInceptionDate;
    private String endorsementExpiryDate;

    private String quoteReferenceNumber;
    private String clientReferenceNumber;
    private String quoteEndorsementNumber;
    private String quoteType;
    private String quoteDescription;
    private String lastSaveParameterVersion;
    private String currentParameterVersion;
    private String currency;
    private Double rateOfExchange;
    private Double rateOfExchangeOverridde;
    private String status;

    private List<CoverageComponent> coverageComponents;


    public Quote() {
    }

    public Quote(Long quoteId,
                 String name,
                 String description,
                 String insuredComapnyName,
                 String insuredCountryOfResidence,
                 String usaTerritory,
                 String usaState,
                 String insuredTypeOfCompany,
                 String insuredLeadOperationalEntity,
                 String countryCurrency,
                 String underwriter,
                 String underwriterEmail,
                 String inceptionDate,
                 String expiryDate,
                 String policyDurationAmount,
                 String policyDurationUnit,
                 String endorsementInceptionDate,
                 String endorsementExpiryDate,
                 String quoteReferenceNumber,
                 String clientReferenceNumber,
                 String quoteEndorsementNumber,
                 String quoteType,
                 String quoteDescription,
                 String lastSaveParameterVersion,
                 String currentParameterVersion,
                 String currency,
                 Double rateOfExchange,
                 Double rateOfExchangeOverridde,
                 String status,
                 List<CoverageComponent> coverageComponents) {

        this.quoteId = quoteId;
        this.name = name;
        this.description = description;
        this.insuredComapnyName = insuredComapnyName;
        this.insuredCountryOfResidence = insuredCountryOfResidence;
        this.usaTerritory = usaTerritory;
        this.usaState = usaState;
        this.insuredTypeOfCompany = insuredTypeOfCompany;
        this.insuredLeadOperationalEntity = insuredLeadOperationalEntity;
        this.countryCurrency = countryCurrency;
        this.underwriter = underwriter;
        this.underwriterEmail = underwriterEmail;
        this.inceptionDate = inceptionDate;
        this.expiryDate = expiryDate;
        this.policyDurationAmount = policyDurationAmount;
        this.policyDurationUnit = policyDurationUnit;
        this.endorsementInceptionDate = endorsementInceptionDate;
        this.endorsementExpiryDate = endorsementExpiryDate;
        this.quoteReferenceNumber = quoteReferenceNumber;
        this.clientReferenceNumber = clientReferenceNumber;
        this.quoteEndorsementNumber = quoteEndorsementNumber;
        this.quoteType = quoteType;
        this.quoteDescription = quoteDescription;
        this.lastSaveParameterVersion = lastSaveParameterVersion;
        this.currentParameterVersion = currentParameterVersion;
        this.currency = currency;
        this.rateOfExchange = rateOfExchange;
        this.rateOfExchangeOverridde = rateOfExchangeOverridde;
        this.status = status;
        this.coverageComponents = coverageComponents;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInsuredComapnyName() {
        return insuredComapnyName;
    }

    public void setInsuredComapnyName(String insuredComapnyName) {
        this.insuredComapnyName = insuredComapnyName;
    }

    public String getInsuredCountryOfResidence() {
        return insuredCountryOfResidence;
    }

    public void setInsuredCountryOfResidence(String insuredCountryOfResidence) {
        this.insuredCountryOfResidence = insuredCountryOfResidence;
    }

    public String getUsaTerritory() {
        return usaTerritory;
    }

    public void setUsaTerritory(String usaTerritory) {
        this.usaTerritory = usaTerritory;
    }

    public String getUsaState() {
        return usaState;
    }

    public void setUsaState(String usaState) {
        this.usaState = usaState;
    }

    public String getInsuredTypeOfCompany() {
        return insuredTypeOfCompany;
    }

    public void setInsuredTypeOfCompany(String insuredTypeOfCompany) {
        this.insuredTypeOfCompany = insuredTypeOfCompany;
    }

    public String getInsuredLeadOperationalEntity() {
        return insuredLeadOperationalEntity;
    }

    public void setInsuredLeadOperationalEntity(String insuredLeadOperationalEntity) {
        this.insuredLeadOperationalEntity = insuredLeadOperationalEntity;
    }

    public String getCountryCurrency() {
        return countryCurrency;
    }

    public void setCountryCurrency(String countryCurrency) {
        this.countryCurrency = countryCurrency;
    }

    public String getUnderwriter() {
        return underwriter;
    }

    public void setUnderwriter(String underwriter) {
        this.underwriter = underwriter;
    }

    public String getUnderwriterEmail() {
        return underwriterEmail;
    }

    public void setUnderwriterEmail(String underwriterEmail) {
        this.underwriterEmail = underwriterEmail;
    }

    public String getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPolicyDurationAmount() {
        return policyDurationAmount;
    }

    public void setPolicyDurationAmount(String policyDurationAmount) {
        this.policyDurationAmount = policyDurationAmount;
    }

    public String getPolicyDurationUnit() {
        return policyDurationUnit;
    }

    public void setPolicyDurationUnit(String policyDurationUnit) {
        this.policyDurationUnit = policyDurationUnit;
    }

    public String getEndorsementInceptionDate() {
        return endorsementInceptionDate;
    }

    public void setEndorsementInceptionDate(String endorsementInceptionDate) {
        this.endorsementInceptionDate = endorsementInceptionDate;
    }

    public String getEndorsementExpiryDate() {
        return endorsementExpiryDate;
    }

    public void setEndorsementExpiryDate(String endorsementExpiryDate) {
        this.endorsementExpiryDate = endorsementExpiryDate;
    }

    public String getQuoteReferenceNumber() {
        return quoteReferenceNumber;
    }

    public void setQuoteReferenceNumber(String quoteReferenceNumber) {
        this.quoteReferenceNumber = quoteReferenceNumber;
    }

    public String getClientReferenceNumber() {
        return clientReferenceNumber;
    }

    public void setClientReferenceNumber(String clientReferenceNumber) {
        this.clientReferenceNumber = clientReferenceNumber;
    }

    public String getQuoteEndorsementNumber() {
        return quoteEndorsementNumber;
    }

    public void setQuoteEndorsementNumber(String quoteEndorsementNumber) {
        this.quoteEndorsementNumber = quoteEndorsementNumber;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    public String getQuoteDescription() {
        return quoteDescription;
    }

    public void setQuoteDescription(String quoteDescription) {
        this.quoteDescription = quoteDescription;
    }

    public String getLastSaveParameterVersion() {
        return lastSaveParameterVersion;
    }

    public void setLastSaveParameterVersion(String lastSaveParameterVersion) {
        this.lastSaveParameterVersion = lastSaveParameterVersion;
    }

    public String getCurrentParameterVersion() {
        return currentParameterVersion;
    }

    public void setCurrentParameterVersion(String currentParameterVersion) {
        this.currentParameterVersion = currentParameterVersion;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getRateOfExchange() {
        return rateOfExchange;
    }

    public void setRateOfExchange(Double rateOfExchange) {
        this.rateOfExchange = rateOfExchange;
    }

    public Double getRateOfExchangeOverridde() {
        return rateOfExchangeOverridde;
    }

    public void setRateOfExchangeOverridde(Double rateOfExchangeOverridde) {
        this.rateOfExchangeOverridde = rateOfExchangeOverridde;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CoverageComponent> getCoverageComponents() {
        return coverageComponents;
    }

    public void setCoverageComponents(List<CoverageComponent> coverageComponents) {
        this.coverageComponents = coverageComponents;
    }
}
