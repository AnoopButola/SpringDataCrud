/**
 * 
 *//*
package com.example.springdata.query;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

*//**
 * @author Anoop Butola
 * Link @AccessingDataMysqlApplication 
 * We can separate our configuration specific to different config but 
 * need to assure that bean should be initialized only 
 * once else container will complain about it.
 * 
 * NOTE:: If we below stuff on @AccessingDataMysqlApplication class behavior will be same 
 * by activating this class.
 *//*
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.example")
@EntityScan(basePackages = "com.example")
public class JPAConfigurationClass {

}



*/