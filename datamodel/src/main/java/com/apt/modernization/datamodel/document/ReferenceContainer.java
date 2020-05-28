package com.apt.modernization.datamodel.document;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "container")
public class ReferenceContainer {
	
    @Id
    private Long containerId;
    
    private String title;
    private String family;
    
    private List<ReferedDocument> childList;
    
    ReferenceContainer(long containerId) {
    	this.containerId=Long.valueOf(containerId);
    	this.childList=null;
    }

	public Long getContainerId() {
		return containerId;
	}
	public void setContainerId(Long containerId) {
		this.containerId = containerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	
	public ReferedDocument[] getChildren() {
		ensureChildList();
		return childList.toArray(new ReferedDocument[childList.size()]);
	}
	public void setChildren(ReferedDocument[] children) {
		ensureChildList();
		childList.clear();
		for (ReferedDocument child : children) {
			childList.add(child);
		}
	}
	public void addChild(ReferedDocument child) {
		ensureChildList();
		childList.add(child);
	}
	
	//
	// Privates
	//
	private void ensureChildList() {
		if (childList==null) {
			childList=new ArrayList<>();
		}
	}
}
