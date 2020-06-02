package com.apt.modernization.datamodel.calculation;

import com.sun.org.apache.bcel.internal.generic.LMUL;
import org.apache.commons.math3.distribution.PoissonDistribution;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Panjer {
    //lambda, mu and sigma values are constant
    private static final double LAMBDA = 0.4;
    private static final double PRECISION = 1.0E-7;

    private List<DistributionValues> xpcAllValues;
    private DistributionValues xpcValues;

    Logger logger = Logger.getLogger(Panjer.class.getName());
    public Panjer() {
    }

    public List<DistributionValues> generateCompoundDistribution(List<DistributionValues> fValues){
        Boolean test = true;
        Double fVal =0.;
        Double equi = fValues.get(1).getxValue()- fValues.get(0).getxValue();
        int k = 0;
        PoissonDistribution poi = new PoissonDistribution(LAMBDA);
        xpcAllValues = new ArrayList<DistributionValues>();
        Double cumulativeValue = 0.;
        Double gValue;
        gValue = poi.probability(0) * Math.exp(fValues.get(0).getPdfValue()*LAMBDA);
        xpcValues = new DistributionValues(fValues.get(0).getxValue(),gValue,gValue);
        cumulativeValue = xpcValues.getPdfValue();
        xpcAllValues.add(xpcValues);
        do{
            k++;
            gValue = 0.;

            for(int j = 1 ; j <= k ; j++){
                fVal = (j >= fValues.size()) ?  0. : fValues.get(j).getPdfValue();
                //logger.info("f (" + j + "): " + fVal);
                //logger.info("g value pdf :  " + gValue);
                //logger.info("g (" + k + " - "+ j + ") :  " + xpcAllValues.get(k-j).getPdfValue());
                gValue += LAMBDA*j*fVal*xpcAllValues.get(k-j).getPdfValue()/k;
            }
            cumulativeValue += gValue;
            xpcValues = new DistributionValues(k * equi,
                    gValue,
                    cumulativeValue);
            xpcAllValues.add(xpcValues);
            if((xpcAllValues.get(k).getCdfValue()-xpcAllValues.get(k-1).getCdfValue() < PRECISION) && xpcAllValues.get(k).getCdfValue() >.9 ) test = false ;
        }
        while(test);
        return xpcAllValues;
    }

}
