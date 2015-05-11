package com.kenpritchard.seeds;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	static final Logger logger = Logger.getLogger(Application.class.getName());
	
	 public static void main(String[] args) {
		 logger.trace("Running SpringApplication...");
	        SpringApplication.run(Application.class, args);
	    }
}
