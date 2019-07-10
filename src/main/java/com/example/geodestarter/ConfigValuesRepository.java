package com.example.geodestarter;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ConfigValuesRepository extends CrudRepository<ConfigValues, String> {

	//List<ConfigValues> findById(String id);
	List<ConfigValues> findByValue(String value);
//	List<ConfigVa>
	
}

