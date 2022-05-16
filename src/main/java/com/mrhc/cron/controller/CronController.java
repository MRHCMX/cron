package com.mrhc.cron.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@ApiOperation("Controller for cron app")

public class CronController {
	private static final Logger LOG = LoggerFactory.getLogger(CronController.class);
	
	@GetMapping("/helloWorld")
	public Object helloWorld() 
	{
		LOG.info("executed CronController helloWorld");
		return "Hello world";
	}

}
