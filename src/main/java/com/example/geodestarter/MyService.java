package com.example.geodestarter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Locale;  

@Service
public class MyService {

  private static Logger logger = LogManager.getLogger(MyService.class);

  @Cacheable("MyService")
  public String sayHelloWorld(String helloString){
    logger.info("************Hitting the service");
    return "Hello" + helloString + System.nanoTime();
  }

  @Cacheable("MyService")
  public String sayHelloWorldWithName(String name){
    logger.info("************Hitting the service");
    // return "Hello" + helloString + System.nanoTime();
    return "Hello " + name.toUpperCase(Locale.forLanguageTag("en")); 
  }

}
