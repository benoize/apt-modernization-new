package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Users {

    @Id
    private Long user_id;
    private String first_name;
    private String last_name;
    private String email;
    private List<Quotes> user_quote_list;


}
