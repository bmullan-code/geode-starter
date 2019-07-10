package com.example.geodestarter;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@EnableEntityDefinedRegions() // basePackageClasses = {Box.class,ConfigValues.class,Region10.class,CompoundKey.class})
@EnableClusterConfiguration(useHttp = true )
@EnablePdx(readSerialized = true)
@EnableGemfireRepositories(basePackageClasses = Region10Repository.class)

public class GeodeStarterApplication {
	
	public static void main(String[] args) {
		
//		Cache c = new CacheFactory()
//				  .setPdxSerializer(new ReflectionBasedAutoSerializer("com.example.geodestarter.Region10"))
//				  .create();
		
//		SpringApplication.run(GeodeStarterApplication.class, args);
		new SpringApplicationBuilder(GeodeStarterApplication.class)
		.web(WebApplicationType.SERVLET)
		.build()
		.run(args);
	}
}

