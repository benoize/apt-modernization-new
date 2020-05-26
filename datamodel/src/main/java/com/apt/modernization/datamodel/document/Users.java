package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Users {

    @Id
    private Long user_id;
    
    private String first_name;
    private String last_name;
    private String email;
    private List<Quotes> user_quote_list;
    
    public Users() {
    	this.user_quote_list=null;
    }
    
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Quotes[] getUserQuotes() {
		ensureUserQuoteList();
		return user_quote_list.toArray(new Quotes[user_quote_list.size()]);
	}
	public void setUserQuotes(Quotes[] quotes) {
		for (Quotes quote : quotes) {
			addUserQuote(quote);
		}
	}
	
	public void addUserQuote(Quotes quotes) {
		ensureUserQuoteList();
		user_quote_list.add(quotes);
	}

	//
	// Utils
	//
	private void ensureUserQuoteList() {
		if (user_quote_list==null) {
			user_quote_list=new ArrayList<>();
		}
	}
}
