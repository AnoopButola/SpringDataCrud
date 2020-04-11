package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableAutoConfiguration
//@EnableJpaRepositories

/*
 * Either create separate class for JPA configuration 
 *   or below one will also work 
 * @EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.example")
@EntityScan(basePackages = "com.example")
 */

@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.example")
@EntityScan(basePackages = "com.example")
@ComponentScan(basePackages ="com.example.*")

public class AccessingDataMysqlApplication {

  public static void main(String[] args) {
   
    ConfigurableApplicationContext ctx= SpringApplication.run(AccessingDataMysqlApplication.class, args);
    
    
    // add a shutdown hook for the above context... 
    ctx.registerShutdownHook();

    // app runs here...

    // main method exits, hook is called prior to the app shutting down...
  }

}