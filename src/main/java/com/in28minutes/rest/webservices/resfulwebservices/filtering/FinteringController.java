package com.in28minutes.rest.webservices.resfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinteringController {
	
	
	@GetMapping("/filtering")
	public SomeBean filtering()
	{
		return new SomeBean("Value_1", "Value_1", "Value_1");
	}
}
