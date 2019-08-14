package com.blogdapp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.blogdapp")
public class BlogDappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogDappApplication.class, args);
	}

}
