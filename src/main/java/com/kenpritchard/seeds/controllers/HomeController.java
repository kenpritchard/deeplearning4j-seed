package com.kenpritchard.seeds.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.kenpritchard.seeds.domain.Example;

@RestController
class HomeController {

	static final Logger logger = Logger.getLogger(HomeController.class.getName());

    @Value("${name}")
    private String theName;

  	@Autowired
  	private Example theGreeting;

    @RequestMapping("/")
    String getGreeting() {
      HomeController.logger.trace("Returning greeting");
  		System.out.println();
        return this.theGreeting.createExample(this.theName);
    }
}