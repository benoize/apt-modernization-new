package com.apt.modernization.datamodel.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coverage_component_configuration")
public class CoverageComponentConfiguration {
    private Long id;
    private String name;
    private String description;

    private Boolean limitsAndRetentionsApplicable;
    private String limitsRetentionsId;
    private Double limitAmount;
    private Double totalLimitAmount;
    private Boolean limitAggregation;
    private Double retention;
    private Double retentionPercentage;
    private Double retentionMinimum;
    private Double retentionMaximum;
    private Double agcsShare;

    private Boolean retentionModifiersApplicable;
    private Boolean claimsHandelingInRetention;
    private Boolean bodilyClaimsOutOfRetention;

    private Boolean claimTriggerApplicable;
    private String claimTrigger;
    private String claimTriggerAuxilliary;
    private String claimsMadeRetroDate;
    private String claimsMadeOutOfReportingPeriod;

    public CoverageComponentConfiguration() {
    }

    public CoverageComponentConfiguration(Long id,
                                          String name,
                                          String description,
                                          Boolean limitsAndRetentionsApplicable,
                                          String limitsRetentionsId,
                                          Double limitAmount,
                                          Double totalLimitAmount,
                                          Boolean limitAggregation,
                                          Double retention,
                                          Double retentionPercentage,
                                          Double retentionMinimum,
                                          Double retentionMaximum,
                                          Double agcsShare,
                                          Boolean retentionModifiersApplicable,
                                          Boolean claimsHandelingInRetention,
                                          Boolean bodilyClaimsOutOfRetention,
                                          Boolean claimTriggerApplicable,
                                          String claimTrigger,
                                          String claimTriggerAuxilliary,
                                          String claimsMadeRetroDate,
                                          String claimsMadeOutOfReportingPeriod
                                          ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.limitsAndRetentionsApplicable = limitsAndRetentionsApplicable;
        this.limitsRetentionsId = limitsRetentionsId;
        this.limitAmount = limitAmount;
        this.totalLimitAmount = totalLimitAmount;
        this.limitAggregation = limitAggregation;
        this.retention = retention;
        this.retentionPercentage = retentionPercentage;
        this.retentionMinimum = retentionMinimum;
        this.retentionMaximum = retentionMaximum;
        this.agcsShare = agcsShare;
        this.retentionModifiersApplicable = retentionModifiersApplicable;
        this.claimsHandelingInRetention = claimsHandelingInRetention;
        this.bodilyClaimsOutOfRetention = bodilyClaimsOutOfRetention;
        this.claimTriggerApplicable = claimTriggerApplicable;
        this.claimTrigger = claimTrigger;
        this.claimTriggerAuxilliary = claimTriggerAuxilliary;
        this.claimsMadeRetroDate = claimsMadeRetroDate;
        this.claimsMadeOutOfReportingPeriod = claimsMadeOutOfReportingPeriod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getLimitsAndRetentionsApplicable() {
        return limitsAndRetentionsApplicable;
    }

    public void setLimitsAndRetentionsApplicable(Boolean limitsAndRetentionsApplicable) {
        this.limitsAndRetentionsApplicable = limitsAndRetentionsApplicable;
    }

    public String getLimitsRetentionsId() {
        return limitsRetentionsId;
    }

    public void setLimitsRetentionsId(String limitsRetentionsId) {
        this.limitsRetentionsId = limitsRetentionsId;
    }

    public Double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Double limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Double getTotalLimitAmount() {
        return totalLimitAmount;
    }

    public void setTotalLimitAmount(Double totalLimitAmount) {
        this.totalLimitAmount = totalLimitAmount;
    }

    public Boolean getLimitAggregation() {
        return limitAggregation;
    }

    public void setLimitAggregation(Boolean limitAggregation) {
        this.limitAggregation = limitAggregation;
    }

    public Double getRetention() {
        return retention;
    }

    public void setRetention(Double retention) {
        this.retention = retention;
    }

    public Double getRetentionPercentage() {
        return retentionPercentage;
    }

    public void setRetentionPercentage(Double retentionPercentage) {
        this.retentionPercentage = retentionPercentage;
    }

    public Double getRetentionMinimum() {
        return retentionMinimum;
    }

    public void setRetentionMinimum(Double retentionMinimum) {
        this.retentionMinimum = retentionMinimum;
    }

    public Double getRetentionMaximum() {
        return retentionMaximum;
    }

    public void setRetentionMaximum(Double retentionMaximum) {
        this.retentionMaximum = retentionMaximum;
    }

    public Double getAgcsShare() {
        return agcsShare;
    }

    public void setAgcsShare(Double agcsShare) {
        this.agcsShare = agcsShare;
    }

    public Boolean getRetentionModifiersApplicable() {
        return retentionModifiersApplicable;
    }

    public void setRetentionModifiersApplicable(Boolean retentionModifiersApplicable) {
        this.retentionModifiersApplicable = retentionModifiersApplicable;
    }

    public Boolean getClaimsHandelingInRetention() {
        return claimsHandelingInRetention;
    }

    public void setClaimsHandelingInRetention(Boolean claimsHandelingInRetention) {
        this.claimsHandelingInRetention = claimsHandelingInRetention;
    }

    public Boolean getBodilyClaimsOutOfRetention() {
        return bodilyClaimsOutOfRetention;
    }

    public void setBodilyClaimsOutOfRetention(Boolean bodilyClaimsOutOfRetention) {
        this.bodilyClaimsOutOfRetention = bodilyClaimsOutOfRetention;
    }

    public Boolean getClaimTriggerApplicable() {
        return claimTriggerApplicable;
    }

    public void setClaimTriggerApplicable(Boolean claimTriggerApplicable) {
        this.claimTriggerApplicable = claimTriggerApplicable;
    }

    public String getClaimTrigger() {
        return claimTrigger;
    }

    public void setClaimTrigger(String claimTrigger) {
        this.claimTrigger = claimTrigger;
    }

    public String getClaimTriggerAuxilliary() {
        return claimTriggerAuxilliary;
    }

    public void setClaimTriggerAuxilliary(String claimTriggerAuxilliary) {
        this.claimTriggerAuxilliary = claimTriggerAuxilliary;
    }

    public String getClaimsMadeRetroDate() {
        return claimsMadeRetroDate;
    }

    public void setClaimsMadeRetroDate(String claimsMadeRetroDate) {
        this.claimsMadeRetroDate = claimsMadeRetroDate;
    }

    public String getClaimsMadeOutOfReportingPeriod() {
        return claimsMadeOutOfReportingPeriod;
    }

    public void setClaimsMadeOutOfReportingPeriod(String claimsMadeOutOfReportingPeriod) {
        this.claimsMadeOutOfReportingPeriod = claimsMadeOutOfReportingPeriod;
    }
}
