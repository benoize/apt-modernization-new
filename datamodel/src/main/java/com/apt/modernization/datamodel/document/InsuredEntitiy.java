package com.apt.modernization.datamodel.document;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "insured_entities")
public class InsuredEntitiy {
    private Long id;
    private String name;
    private String description;
    private Boolean inheritance;

    private String insureableEntityName;
    private String insureableEntityCategoryId;
    private String insureableEntityCategoryName;
    private String insureableEntityCategoryTypeId;
    private String insureableEntityCategoryTypeName;
    private String insureableEntityExposureMeasureId;
    private String insureableEntityExposureMeasureName;
    private Double insureableEntityExposureMeasureAmount;
    private String insureableEntityExposureMeasureCurrency;

    private String InstantiatorName;
    private String InstantiatorDomicileId;
    private String InstantiatorDomicileName;
    private String InstantiatorDomicileType;
    private String InstantiatorOperationalEntityId;
    private String InstantiatorOperationalEntityName;
    private String InstantiatorOperationalEntityType;

    private RiskModifier riskModifier;


    public InsuredEntitiy() {
    }


    public InsuredEntitiy(Long id,
                          String name,
                          String description,
                          Boolean inheritance,
                          String insureableEntityName,
                          String insureableEntityCategoryId,
                          String insureableEntityCategoryName,
                          String insureableEntityCategoryTypeId,
                          String insureableEntityCategoryTypeName,
                          String insureableEntityExposureMeasureId,
                          String insureableEntityExposureMeasureName,
                          Double insureableEntityExposureMeasureAmount,
                          String insureableEntityExposureMeasureCurrency,
                          String InstantiatorName,
                          String InstantiatorDomicileId,
                          String InstantiatorDomicileName,
                          String InstantiatorDomicileType,
                          String InstantiatorOperationalEntityId,
                          String InstantiatorOperationalEntityName,
                          String InstantiatorOperationalEntityType
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inheritance = inheritance;
        this.insureableEntityName = insureableEntityName;
        this.insureableEntityCategoryId = insureableEntityCategoryId;
        this.insureableEntityCategoryName = insureableEntityCategoryName;
        this.insureableEntityCategoryTypeId = insureableEntityCategoryTypeId;
        this.insureableEntityCategoryTypeName = insureableEntityCategoryTypeName;
        this.insureableEntityExposureMeasureId = insureableEntityExposureMeasureId;
        this.insureableEntityExposureMeasureName = insureableEntityExposureMeasureName;
        this.insureableEntityExposureMeasureAmount = insureableEntityExposureMeasureAmount;
        this.insureableEntityExposureMeasureCurrency = insureableEntityExposureMeasureCurrency;
        this.InstantiatorName = InstantiatorName;
        this.InstantiatorDomicileId = InstantiatorDomicileId;
        this.InstantiatorDomicileName = InstantiatorDomicileName;
        this.InstantiatorDomicileType = InstantiatorDomicileType;
        this.InstantiatorOperationalEntityId = InstantiatorOperationalEntityId;
        this.InstantiatorOperationalEntityName = InstantiatorOperationalEntityName;
        this.InstantiatorOperationalEntityType = InstantiatorOperationalEntityType;

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

    public Boolean getInheritance() {
        return inheritance;
    }

    public void setInheritance(Boolean inheritance) {
        this.inheritance = inheritance;
    }

    public String getInsureableEntityName() {
        return insureableEntityName;
    }

    public void setInsureableEntityName(String insureableEntityName) {
        this.insureableEntityName = insureableEntityName;
    }

    public String getInsureableEntityCategoryId() {
        return insureableEntityCategoryId;
    }

    public void setInsureableEntityCategoryId(String insureableEntityCategoryId) {
        this.insureableEntityCategoryId = insureableEntityCategoryId;
    }

    public String getInsureableEntityCategoryName() {
        return insureableEntityCategoryName;
    }

    public void setInsureableEntityCategoryName(String insureableEntityCategoryName) {
        this.insureableEntityCategoryName = insureableEntityCategoryName;
    }

    public String getInsureableEntityCategoryTypeId() {
        return insureableEntityCategoryTypeId;
    }

    public void setInsureableEntityCategoryTypeId(String insureableEntityCategoryTypeId) {
        this.insureableEntityCategoryTypeId = insureableEntityCategoryTypeId;
    }

    public String getInsureableEntityCategoryTypeName() {
        return insureableEntityCategoryTypeName;
    }

    public void setInsureableEntityCategoryTypeName(String insureableEntityCategoryTypeName) {
        this.insureableEntityCategoryTypeName = insureableEntityCategoryTypeName;
    }

    public String getInsureableEntityExposureMeasureId() {
        return insureableEntityExposureMeasureId;
    }

    public void setInsureableEntityExposureMeasureId(String insureableEntityExposureMeasureId) {
        this.insureableEntityExposureMeasureId = insureableEntityExposureMeasureId;
    }

    public String getInsureableEntityExposureMeasureName() {
        return insureableEntityExposureMeasureName;
    }

    public void setInsureableEntityExposureMeasureName(String insureableEntityExposureMeasureName) {
        this.insureableEntityExposureMeasureName = insureableEntityExposureMeasureName;
    }

    public Double getInsureableEntityExposureMeasureAmount() {
        return insureableEntityExposureMeasureAmount;
    }

    public void setInsureableEntityExposureMeasureAmount(Double insureableEntityExposureMeasureAmount) {
        this.insureableEntityExposureMeasureAmount = insureableEntityExposureMeasureAmount;
    }

    public String getInsureableEntityExposureMeasureCurrency() {
        return insureableEntityExposureMeasureCurrency;
    }

    public void setInsureableEntityExposureMeasureCurrency(String insureableEntityExposureMeasureCurrency) {
        this.insureableEntityExposureMeasureCurrency = insureableEntityExposureMeasureCurrency;
    }

    public String getInstantiatorName() {
        return InstantiatorName;
    }

    public void setInstantiatorName(String instantiatorName) {
        InstantiatorName = instantiatorName;
    }

    public String getInstantiatorDomicileId() {
        return InstantiatorDomicileId;
    }

    public void setInstantiatorDomicileId(String instantiatorDomicileId) {
        InstantiatorDomicileId = instantiatorDomicileId;
    }

    public String getInstantiatorDomicileName() {
        return InstantiatorDomicileName;
    }

    public void setInstantiatorDomicileName(String instantiatorDomicileName) {
        InstantiatorDomicileName = instantiatorDomicileName;
    }

    public String getInstantiatorDomicileType() {
        return InstantiatorDomicileType;
    }

    public void setInstantiatorDomicileType(String instantiatorDomicileType) {
        InstantiatorDomicileType = instantiatorDomicileType;
    }

    public String getInstantiatorOperationalEntityId() {
        return InstantiatorOperationalEntityId;
    }

    public void setInstantiatorOperationalEntityId(String instantiatorOperationalEntityId) {
        InstantiatorOperationalEntityId = instantiatorOperationalEntityId;
    }

    public String getInstantiatorOperationalEntityName() {
        return InstantiatorOperationalEntityName;
    }

    public void setInstantiatorOperationalEntityName(String instantiatorOperationalEntityName) {
        InstantiatorOperationalEntityName = instantiatorOperationalEntityName;
    }

    public String getInstantiatorOperationalEntityType() {
        return InstantiatorOperationalEntityType;
    }

    public void setInstantiatorOperationalEntityType(String instantiatorOperationalEntityType) {
        InstantiatorOperationalEntityType = instantiatorOperationalEntityType;
    }

    public RiskModifier getRiskModifier() {
        return riskModifier;
    }

    public void setRiskModifier(RiskModifier riskModifier) {
        this.riskModifier = riskModifier;
    }
}
