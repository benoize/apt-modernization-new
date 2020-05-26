package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Users {

    @Id
    private Long userId;
    
    private String firstName;
    private String lastName;
    private String email;
    private List<Quotes> userQuoteList;
    
    public Users() {
    	this.userQuoteList=null;
    }
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Quotes[] getUserQuotes() {
		ensureUserQuoteList();
		return userQuoteList.toArray(new Quotes[userQuoteList.size()]);
	}
	public void setUserQuotes(Quotes[] quotes) {
		for (Quotes quote : quotes) {
			addUserQuote(quote);
		}
	}
	
	public void addUserQuote(Quotes quotes) {
		ensureUserQuoteList();
		userQuoteList.add(quotes);
	}

	//
	// Utils
	//
	private void ensureUserQuoteList() {
		if (userQuoteList==null) {
			userQuoteList=new ArrayList<>();
		}
	}
}
