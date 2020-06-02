package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coverage_component")
public class CoverageComponent {

    @Id
    private Long id;
    private String name;
    private String description;
    private String inheritance;
    private CoverageComponentConfiguration coverageComponentConfiguration;
    private PremiumCoverageComponent premiumCoverageComponent;
    private InsuredEntitiy insuredEntitiy;


    public CoverageComponent() {
    }

    public CoverageComponent(Long id,
                             String name,
                             String description,
                             String inheritance,
                             CoverageComponentConfiguration coverageComponentConfiguration,
                             PremiumCoverageComponent premiumCoverageComponent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inheritance = inheritance;
        this.coverageComponentConfiguration = coverageComponentConfiguration;
        this.premiumCoverageComponent = premiumCoverageComponent;

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

    public String getInheritance() {
        return inheritance;
    }

    public void setInheritance(String inheritance) {
        this.inheritance = inheritance;
    }

    public CoverageComponentConfiguration getCoverageComponentConfiguration() {
        return coverageComponentConfiguration;
    }

    public void setCoverageComponentConfiguration(CoverageComponentConfiguration coverageComponentConfiguration) {
        this.coverageComponentConfiguration = coverageComponentConfiguration;
    }

    public PremiumCoverageComponent getPremiumCoverageComponent() {
        return premiumCoverageComponent;
    }

    public void setPremiumCoverageComponent(PremiumCoverageComponent premiumCoverageComponent) {
        this.premiumCoverageComponent = premiumCoverageComponent;
    }

    public InsuredEntitiy getInsuredEntitiy() {
        return insuredEntitiy;
    }

    public void setInsuredEntitiy(InsuredEntitiy insuredEntitiy) {
        this.insuredEntitiy = insuredEntitiy;
    }
}
