package com.kenpritchard.seeds.domain;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Example {
	
	static final Logger logger = Logger.getLogger(Example.class.getName());
	public String createExample(String name) {
		Example.logger.trace(String.format("Creating greeting for %s", name));
		return String.format("Hello %s!", name);
	}
	
}

