package com.youlearncode.springbootcomponentannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.youlearncode.springbootcomponentannotation","ignoredpackage"})
public class SpringbootcomponentannotationApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(
				SpringbootcomponentannotationApplication.class, args
		);
		System.out.println(ctx.getBean("customName"));
		System.out.println(ctx.getBean("dao"));
		System.out.println(ctx.getBean("AClass"));
		System.out.println(ctx.getBean("myService"));
		System.out.println(ctx.getBean("ignored"));
	}

}
