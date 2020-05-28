package com.apt.modernization.datamodel.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "refered")
public class ReferedDocument {
	
    @Id
    private Long referedId;
    
    private String name;
    private String details;
    private String description;
    
    public ReferedDocument(Long referedId) {
    	this.referedId=referedId;
    }
    
	public Long getReferedId() {
		return referedId;
	}
	public void setReferedId(Long referedId) {
		this.referedId = referedId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
