package com.in28minutes.rest.webservices.resfulwebservices.helloworld;

//Rest API
//URI: /hello-world

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Adding annotation to make this controlle a rest controller
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world") //Annotation to bind the uri "/hello-world"
    public String helloworld()
    {
        return "Hello World";
    }
}
