package com.codelearnhub.springBootProfiles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.Arrays;

@SpringBootTest
@ActiveProfiles(resolver = Resolver.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
class SpringBootProfilesApplicationTests {

	@Autowired
	ConfigurableEnvironment configurableEnvironment;

	@Test
	void contextLoads() {
		Arrays
				.stream(configurableEnvironment.getActiveProfiles())
				.forEach(System.out::println);
	}

}
