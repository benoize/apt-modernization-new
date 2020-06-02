package com.apt.modernization.datamodel.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "premium_coverage_component")
public class PremiumCoverageComponent {

    private Double expectedLoss;

    public PremiumCoverageComponent(Double expectedLoss) {
        this.expectedLoss = expectedLoss;
    }

    public PremiumCoverageComponent() {
    }

    public Double getExpectedLoss() {
        return expectedLoss;
    }

    public void setExpectedLoss(Double expectedLoss) {
        this.expectedLoss = expectedLoss;
    }
}
