package com.example.geodestarter;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.geode.pdx.JSONFormatter;
import org.apache.geode.pdx.PdxInstance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;  

@RestController
public class HelloController {

  private static Logger logger = LogManager.getLogger(HelloController.class);

  private final MyService helloWorldService;

  @Autowired
  public HelloController(
      MyService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  @RequestMapping("/hello")
  public String sayHello(){
    logger.info("**Received request**");
    return helloWorldService.sayHelloWorld("HelloWorld");
  }

  @RequestMapping("/hello/{name}")
  // @RequestMapping(value = "/greetings/{id}", method = RequestMethod.GET)
  public String sayHelloWithName(
    @PathVariable("name") String name) {
    logger.info("**Received request with name:"+name);
    return helloWorldService.sayHelloWorldWithName(name);
    // return name.toUpperCase(Locale.forLanguageTag("en")); 
  }
  
  @RequestMapping("/")
  public String ping(){
    logger.info("**Received request**");

    return "<h1>Pong<h1>";
  }
  
  @Autowired
  public BoxRepository repo;
  @Autowired
  public ConfigValuesRepository configs;
  @Autowired
  public Region10Repository region10s;
  
  @RequestMapping("/boxes")
  public Iterable<Box> boxes() {
	  
	  repo.save(new Box("foo",50,100,99));
	  
	  return repo.findAll();
  }
  
  @RequestMapping(value = "/boxes", method = RequestMethod.POST) 
  public void postBoxes(@RequestBody Box box) {
	  repo.save(box);
  }
  
  @RequestMapping("/createKeys")
  public Iterable<ConfigValues> createKeys() {
	  region10s.save(new Region10(new CompoundKey("Facility10","Option1"),"101"));
	  region10s.save(new Region10(new CompoundKey("Facility10","Option2"),"102"));
	  region10s.save(new Region10(new CompoundKey("Facility10","Option3"),"103"));
	  region10s.save(new Region10(new CompoundKey("Facility20","Option1"),"201"));
	  region10s.save(new Region10(new CompoundKey("Facility20","Option2"),"202"));
	  region10s.save(new Region10(new CompoundKey("Facility20","Option3"),"203"));
	  
	  configs.save(new ConfigValues("show:us:ma:medford","3"));
	  configs.save(new ConfigValues("show:us:ma","2"));
	  configs.save(new ConfigValues("show:us","1"));
//	  
////	  region10s.save(new Region10("Facility10","Option1","11"));
////	  region10s.save(new Region10("Facility10","Option2","12"));
////	  region10s.save(new Region10("Facility10","Option3","13"));
////	  region10s.save(new Region10("Facility20","Option1","21"));
////	  region10s.save(new Region10("Facility20","Option2","22"));
////	  region10s.save(new Region10("Facility20","Option3","23"));
	  
	  return configs.findAll();
  }

  @RequestMapping("/findByValue/{value}")
  public List<ConfigValues> findByValue(@PathVariable("value") String value) {
	  return configs.findByValue(value);
  }
  
  @RequestMapping("/findConfigValue/{id}")
  public Optional<ConfigValues> findConfigValue(@PathVariable("id") String id) {
	  
	  Optional<ConfigValues> config = configs.findById(id); 
	  System.out.println("id:" + id + ":" + config.toString());
	  if (config!=null && config.isPresent()) {
		  return config;
	  } else {
		  String[] parts = id.split(":");
		  if (parts.length>1) {
			  parts = Arrays.copyOf(parts, parts.length-1);
			  String newKey = String.join(":", parts);
			  System.out.println("NewKey:"+newKey);
			  return findConfigValue(newKey);
		  } else {
			  // not found
			  return null;
		  }
	  }
  }
  
  @RequestMapping("/findByFacilityAndAppOption/{facility}/{appoption}")
  public Collection<Region10> findByFacilityAndAppOption(@PathVariable("facility") String facility,
		  @PathVariable("appoption") String appOption) {
	  
	  List<Region10> objs = region10s.findByFacilityIdAndAppOption(facility, appOption);
	  System.out.println(objs);
	  for (Object o : objs) {
		  System.out.println("Object:"+o);
		  System.out.println( JSONFormatter.toJSON((PdxInstance) o).toString());
	  }
	  return objs;
  }

  
  	
}