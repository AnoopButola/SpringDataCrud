package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.*")
public class AccessingDataMysqlApplication {

  public static void main(String[] args) {
   
    ConfigurableApplicationContext ctx= SpringApplication.run(AccessingDataMysqlApplication.class, args);
    
    
    // add a shutdown hook for the above context... 
    ctx.registerShutdownHook();

    // app runs here...

    // main method exits, hook is called prior to the app shutting down...
  }

}