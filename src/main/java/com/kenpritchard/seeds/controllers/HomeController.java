package com.kenpritchard.seeds.controllers;

import java.util.Collection;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.kenpritchard.seeds.domain.GloveRequest;
import com.kenpritchard.seeds.services.GloveService;

@RestController
class HomeController {

	static final Logger logger = Logger.getLogger(HomeController.class.getName());

	@Autowired
	private GloveService gloveService;

	@RequestMapping(value = "/learnText", method = RequestMethod.POST)
	Collection<String> learnText(@RequestBody GloveRequest request) {
		HomeController.logger.trace(String.format("Received: %s", request));
		Collection<String> results = this.gloveService.getSimilarStrings(request);
		HomeController.logger.trace(String.format("Returning: %s", results));
		return results;
	}
}
