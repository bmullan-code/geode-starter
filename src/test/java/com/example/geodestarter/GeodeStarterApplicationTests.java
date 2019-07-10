package com.example.geodestarter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeodeStarterApplicationTests {
	
	@Autowired
	public ConfigValuesRepository configs;
	  

	@Test
	public void contextLoads() {
	}
	
	public void setup() {
		configs.save(new ConfigValues("show:us:ma:medford","true"));
		configs.save(new ConfigValues("show:us:ma:holliston","false"));
	}
	
	@Test
	public void testLookup() {
		Optional<ConfigValues> config = configs.findById("show:us:ma:medford");
		System.out.println(config.toString());
		
		Assert.assertEquals(configs.findById("show:us:ma:medford").get().getValue(),"true");
		Assert.assertEquals(configs.findById("show:us:ma:holliston").get().getValue(),"false");
	}

}
