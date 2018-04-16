package com.cvs.simulator.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/simulatorservice")
public interface simulatorService {

	@RequestMapping(value = "/storefeed", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> getStoreFeed(@RequestBody StoreFeedRequest storeFeedRequest);

	@RequestMapping(value = "/home", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	String home();
	
	
}
