package com.apt.modernization.datamodel.calculation;

//import cern.jet.random.Distributions;
//import cern.jet.random.Normal;
//import cern.jet.random.engine.RandomEngine;
//import com.apt.modernization.datamodel.document.CoverageComponentConfiguration;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class EquiDistributionVector{
    private static final int STEPS = 200;
    private static final double SIGMA = .75;
    private static final double MU = 10;

    private List<DistributionValues> xpcValues;
    private DistributionValues xpcValue;
    private Double retention;
    private Double limit;
    private Double equiDistance;
    private Double mu;

    Logger logger = Logger.getLogger(EquiDistributionVector.class.getName());
    public EquiDistributionVector() {
    }

    public EquiDistributionVector(Double retention, Double limit, Double mu) {
        this.retention = retention;
        this.limit = limit;
        this.mu = mu;
    }

    public List<DistributionValues> createLogNormalVector(){
        xpcValues = new ArrayList<DistributionValues>();
        equiDistance = (limit - retention)/STEPS;
        xpcValue = new DistributionValues(equiDistance * 0,
                cdfLogNormal(retention),cdfLogNormal(retention));
        //logger.info(xpcValue.getxValue() + ", " + xpcValue.getPdfValue()+ ", " + xpcValue.getCdfValue());
        xpcValues.add(xpcValue);
        for(int i = 1; i < STEPS-1 ; i++){
            xpcValue = new DistributionValues(equiDistance * i,
                                        cdfLogNormal(i*equiDistance + retention) - xpcValues.get(i-1).getCdfValue(),
                                                cdfLogNormal(i*equiDistance + retention));
            //logger.info(xpcValue.getxValue() + ", " + xpcValue.getPdfValue()+ ", " + xpcValue.getCdfValue());
            xpcValues.add(xpcValue);
        }
        xpcValue = new DistributionValues(limit,
                                1 - cdfLogNormal(retention + limit) ,
                                        1. );

        //logger.info(xpcValue.getxValue() + ", " + xpcValue.getPdfValue()+ ", " + xpcValue.getCdfValue());
        xpcValues.add(xpcValue);
        return xpcValues;
    }

    public Double cdfLogNormal(Double x){
        NormalDistribution n = new NormalDistribution(MU, SIGMA);
        //logger.info("ln x: " + Math.log(x) + ", " + " total log value: " + (Math.log(x)-MU)/SIGMA);
        //logger.info("x value:" + x + ", cumm value: " +  n.cumulativeProbability((Math.log(x)-MU)/SIGMA));
        return n.cumulativeProbability((Math.log(x)-MU)/SIGMA);
    }

}
