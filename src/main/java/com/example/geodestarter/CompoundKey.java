package com.example.geodestarter;

import java.io.Serializable;

public class CompoundKey implements Serializable {

	private String appOption;
	private String facilityId;
	
	
	public CompoundKey() {
	}	
	
	public CompoundKey(String facilityId, String appOption) {
		this.facilityId = facilityId;
		this.appOption = appOption;
	}
	
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
}