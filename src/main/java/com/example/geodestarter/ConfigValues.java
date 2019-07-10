package com.example.geodestarter;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("ConfigValues")
public class ConfigValues implements Serializable  {
	
	@Id
	private String id;
	private String value;
	
	public ConfigValues() {
		
	}
	
	public ConfigValues(String id, String value) {
		super();
		this.id = id;
		this.setValue(value);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


}
