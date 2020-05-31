package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.eventshandling.EventModel;
import com.example.eventshandling.EventModel.TaskType;

//import com.example.swagger.config.CommonSwaggerConfiguration;

@SpringBootApplication
// @EnableAutoConfiguration
// @EnableJpaRepositories

/*
 * Either create separate class for JPA configuration or below one will also
 * work
 * 
 * @EnableTransactionManagement(proxyTargetClass = true)
 * 
 * @EnableJpaRepositories(basePackages = "com.example")
 * 
 * @EntityScan(basePackages = "com.example")
 */

// @Import({CommonSwaggerConfiguration.class})
@EnableAutoConfiguration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.example")
@EntityScan(basePackages = "com.example")
@ComponentScan(basePackages = "com.example.*")

public class AccessingDataMysqlApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(AccessingDataMysqlApplication.class, args);

		// System.out.println("Swagger URL is ::
		// "+CommonSwaggerConfiguration.getSwaggerURL());

		addInitHooks(ctx);
		// add a shutdown hook for the above context...
		ctx.registerShutdownHook();

		// app runs here...

		// main method exits, hook is called prior to the app shutting down...
	}

	/**
	 * @param ctx
	 */
	private static void addInitHooks(ConfigurableApplicationContext ctx) {
		//once context is availabe we can also put custom logic we want to notify some another app etc
		if (ctx.isActive()) {
			System.out.println("context is available :::");
			EventModel.EventModelDetail model=new EventModel.EventModelDetail();
			model.setCreatedUser("Bootstrap_CREATED");
			model.setMessage("Setting password in encoded form");
			model.setTaskType(TaskType.BOOTSTRAP_TASK);
			EventModel event=new EventModel(model);
			ctx.publishEvent(event);
		}
		
	}

}