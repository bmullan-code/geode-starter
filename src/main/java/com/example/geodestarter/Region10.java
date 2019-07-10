package com.example.geodestarter;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("Region10")
public class Region10 implements Serializable { 
	
	@Id
	private CompoundKey key;

	public CompoundKey getKey() {
		return key;
	}

	public void setKey(CompoundKey key) {
		this.key = key;
		this.setFacilityId(key.getFacilityId());
		this.setAppOption(key.getAppOption());
	}

	private String value;
	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getAppOption() {
		return appOption;
	}

	public void setAppOption(String appOption) {
		this.appOption = appOption;
	}

	private String facilityId;
	private String appOption;

	public Region10() {
	}
	
	public Region10(CompoundKey key, String value) {
		super();
		this.setKey(key);
		this.setValue(value);
//		this.setFacilityId(key.getFacilityId());
//		this.setAppOption(key.getAppOption());
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}



}
