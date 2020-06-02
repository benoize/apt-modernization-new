package com.apt.modernization.datamodel.calculation;

import java.util.ArrayList;
import java.util.List;

public class DistributionValues {
    private Double xValue;
    private Double pdfValue;
    private Double cdfValue;

    public DistributionValues(Double xValue, Double pdfValue,Double cdfValue) {
        this.xValue = xValue;
        this.pdfValue = pdfValue;
        this.cdfValue = cdfValue;
    }

    public List<Double> valuePair(){
        List<Double> list = new ArrayList<>();
        list.add(xValue);
        list.add(pdfValue);
        list.add(cdfValue);
        return list;
    }

    public Double getxValue() {
        return xValue;
    }

    public void setxValue(Double xValue) {
        this.xValue = xValue;
    }

    public Double getPdfValue() {
        return pdfValue;
    }

    public void setPdfValue(Double pdfValue) {
        this.pdfValue = pdfValue;
    }

    public Double getCdfValue() {
        return cdfValue;
    }

    public void setCdfValue(Double cdfValue) {
        this.cdfValue = cdfValue;
    }
}
