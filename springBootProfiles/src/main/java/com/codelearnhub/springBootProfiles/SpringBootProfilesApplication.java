package com.codelearnhub.springBootProfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class SpringBootProfilesApplication {

	public static void main(String[] args) {

//		ConfigurableEnvironment environment = new StandardEnvironment();
//		environment.setActiveProfiles("dev", "test");

		SpringApplication app = new SpringApplication(SpringBootProfilesApplication.class);
//		app.setEnvironment(environment);
		var ctx = app.run(args);
//		String[] defaultProfiles = ctx.getEnvironment().getDefaultProfiles();
//		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();

	}

}
