package com.in28minutes.rest.webservices.resfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	//Versioning using different URI
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson(){
		return new PersonV1("Bob Charlies");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson(){
		
		return new PersonV2(new Name ("Bob", "Charly"));
	}
	
	//Versioning using path parameter
	
	@GetMapping(path="/person", params="version=1") //Call this function only if param version passed with value 1
	public PersonV1 getFirstVersionOfPersonRequestParameter(){
		return new PersonV1("Bob Charlies");
	}
	
	@GetMapping(path="/person", params="version=2") //Call this function only if param version passed with value 1
	public PersonV2 getSecondVersionOfPersonRequestParameter(){
		return new PersonV2(new Name ("Bob", "Charly"));
	}
	
	
	//Versioning using header
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=1") //Call this function only if header's key (X-API-VERSION) has the value 1
	public PersonV1 getFirstVersionOfPersonRequestHeader(){
		return new PersonV1("Bob Charlies");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2") //Call this function only if header's key (X-API-VERSION) has the value 2
	public PersonV2 getSecondVersionOfPersonRequestHeader(){
		return new PersonV2(new Name ("Bob", "Charly"));
	}
	
	
	//Media type versioning

	/*
	 * In order to get the v1 consumer needs to pass accept key in the header with value: //Call this function only if param version passed with value 1
	 * produces in GetMapping then compares the value and if it matches then call the function
	 */
	@GetMapping(path="/person/accept", produces="application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonRequestMaping(){
		return new PersonV1("Bob Charlies");
	}
	
	@GetMapping(path="/person/accept", produces="application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonRequestMaping(){
		return new PersonV2(new Name ("Bob", "Charly"));
	}
	
	
	//Versioning REST API Factors, which one to choose
	
	
}
