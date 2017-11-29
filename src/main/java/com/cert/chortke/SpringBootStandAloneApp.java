package com.cert.chortke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootStandAloneApp extends SpringBootServletInitializer {

	
	 public static void main(String[] args) {

		  SpringApplication.run(SpringBootStandAloneApp.class, args);

		 }
}
