package com.example.geodestarter;


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
  
  @RequestMapping("/boxes")
  public Iterable<Box> boxes() {
	  
	  repo.save(new Box("foo",50,100,99));
	  
	  return repo.findAll();
  }
  
  @RequestMapping(value = "/boxes", method = RequestMethod.POST) 
  public void postBoxes(@RequestBody Box box) {
	  repo.save(box);
  }

}