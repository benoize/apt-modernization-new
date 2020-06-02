package com.apt.modernization.datamodel.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "risk_modifier")
public class RiskModifier {

    private String id;
    private String name;
    private String description;
    private String tradeCode1;
    private String tradeCode2;
    private String tradeCode3;
    private String tradeCode4;
    private String tradeCode5;
    private String tradeCode6;




}
