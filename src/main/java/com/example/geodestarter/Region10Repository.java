package com.example.geodestarter;

import java.util.List;

import org.springframework.data.gemfire.repository.query.annotation.Import;
import org.springframework.data.repository.CrudRepository;

public interface Region10Repository extends CrudRepository<Region10, CompoundKey> {

//	@Import("com.example.geodestarter.Region10")
	List<Region10> findByFacilityIdAndAppOption(String facilityId, String appOption);
	
}



