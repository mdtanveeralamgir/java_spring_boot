package com.in28minutes.rest.webservices.resfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinteringController {
	
	
	@GetMapping("/filtering")
	public SomeBean filtering()
	{
		return new SomeBean("Value_1", "Value_1", "Value_1");
	}
	
	
	@GetMapping("/filtering_list")
	public List<SomeBean> filteringList()
	{
		return Arrays.asList(new SomeBean("Value_1", "Value_1", "Value_1"), new SomeBean("Value_4", "Value_5", "Value_6"));
	}
}
