package com.apt.modernization.datamodel.document;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "container")
public class Container {
	
    @Id
    private Long containerId;
    
    private String name;
    
    @DBRef
    private List<Child> listChildReferenced;
    
    private Child embedded;
    @DBRef
    private Child referenced;
    
    public Container(long containerId) {
    	this.containerId=Long.valueOf(containerId);
    	this.listChildReferenced=null;
    }

	public Long getContainerId() {
		return containerId;
	}
	public void setContainerId(Long containerId) {
		this.containerId = containerId;
	}
	public String getTitle() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Child getEmbedded() {
		return embedded;
	}
	public void setEmbedded(Child embedded) {
		this.embedded = embedded;
	}
	public Child getReferenced() {
		return referenced;
	}
	public void setReferenced(Child referenced) {
		this.referenced = referenced;
	}
	
	public Child[] getChildren() {
		ensureListChildReferenced();
		return listChildReferenced.toArray(new Child[listChildReferenced.size()]);
	}
	public void setChildren(Child[] children) {
		ensureListChildReferenced();
		listChildReferenced.clear();
		for (Child child : children) {
			listChildReferenced.add(child);
		}
	}
	public void addChild(Child child) {
		ensureListChildReferenced();
		listChildReferenced.add(child);
	}
	
	//
	// Privates
	//
	private void ensureListChildReferenced() {
		if (listChildReferenced==null) {
			listChildReferenced=new ArrayList<>();
		}
	}
}
