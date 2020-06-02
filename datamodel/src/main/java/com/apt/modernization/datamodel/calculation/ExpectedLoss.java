package com.apt.modernization.datamodel.calculation;

import java.util.List;

public class ExpectedLoss {
    List<DistributionValues> distributionValuesList;
    Double expectedLoss;

    public ExpectedLoss(List<DistributionValues> distributionValuesList) {
        this.distributionValuesList = distributionValuesList;
    }

    public Double expectedValueLimit(Double limit){
        DistributionValues d;
        expectedLoss = 0.;
        for(DistributionValues distributionValues : distributionValuesList){
            if(distributionValues.getxValue() > limit){
                d = distributionValuesList.get(distributionValuesList.indexOf(distributionValues)-1);
                expectedLoss += d.getPdfValue() * d.getxValue();
                break;
            }
        }
        return expectedLoss;
    }

    public Double expectedValue(){
        DistributionValues d;
        expectedLoss = 0.;
        for(DistributionValues distributionValues : distributionValuesList){
            d = distributionValuesList.indexOf(distributionValues) != 0 ?  distributionValuesList.get(distributionValuesList.indexOf(distributionValues)-1): distributionValuesList.get(0);
            expectedLoss += d.getPdfValue() * d.getxValue();
        }
        return expectedLoss;
    }
}
