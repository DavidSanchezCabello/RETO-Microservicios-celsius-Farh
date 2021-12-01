package com.dscode.aplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TestController {

	private static Counter counterCel;
	private static Counter counterFar;
	
	
	private final static Logger logger= LoggerFactory.getLogger(TestController.class);
	
	@GetMapping(path="/celAFar/{celsius}")
	public static float celsiusAFahrenheit(@PathVariable float celsius) {
		counterCel.increment();
		logger.info("Llamadas al endpoint celsius:" + counterCel.count());
		
		return (celsius * 1.8f) + 32;
	}
	
	@GetMapping(path="/farACel/{fahrenheit}")
	public static float fahrenheitACelsius(@PathVariable float fahrenheit) {
		counterFar.increment();
		logger.info("Llamadas al endpoint fahrenheit:" + counterFar.count());
		
		return (fahrenheit - 32) / 1.8f;
	}
}
