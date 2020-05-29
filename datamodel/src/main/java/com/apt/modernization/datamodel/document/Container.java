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
    
    // Arrays
    private List<Child> listChildEmbedded;
    @DBRef
    private List<Child> listChildReferenced;
    
    // Singles
    private Child embedded;
    @DBRef
    private Child referenced;
    
    public Container(long containerId) {
    	this.containerId=Long.valueOf(containerId);
    	this.listChildEmbedded=null;
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
	
	public Child[] getChildrenReferenced() {
		ensureListChildReferenced();
		return listChildReferenced.toArray(new Child[listChildReferenced.size()]);
	}
	public void setChildrenReferenced(Child[] children) {
		ensureListChildReferenced();
		listChildReferenced.clear();
		for (Child child : children) {
			listChildReferenced.add(child);
		}
	}
	public void addChildReferenced(Child child) {
		ensureListChildReferenced();
		listChildReferenced.add(child);
	}
	
	public Child[] getChildrenEmbedded() {
		ensureListChildEmbedded();
		return listChildEmbedded.toArray(new Child[listChildEmbedded.size()]);
	}
	public void setChildrenEmbedded(Child[] children) {
		ensureListChildEmbedded();
		listChildEmbedded.clear();
		for (Child child : children) {
			listChildEmbedded.add(child);
		}
	}
	public void addChildEmbedded(Child child) {
		ensureListChildEmbedded();
		listChildEmbedded.add(child);
	}
	
	//
	// Privates
	//
	private void ensureListChildReferenced() {
		if (listChildReferenced==null) {
			listChildReferenced=new ArrayList<>();
		}
	}
	private void ensureListChildEmbedded() {
		if (listChildEmbedded==null) {
			listChildEmbedded=new ArrayList<>();
		}
	}
}
