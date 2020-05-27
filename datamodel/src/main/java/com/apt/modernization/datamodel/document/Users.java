package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class Users {

    @Id
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<Long> quoteListIds;

    public Users(){
    }

    public Users(Long user_id, String firstName, String lastName, String email, List<Long> quoteListIds) {
        this.userId = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.quoteListIds = quoteListIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getfirstName() {
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

    public List<Long> getQuoteListIds() {
        return quoteListIds;
    }

    public void setQuoteListIds(List<Long> quoteListIds) {
        this.quoteListIds = quoteListIds;
    }
}
