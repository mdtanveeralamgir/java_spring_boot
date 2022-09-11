package com.in28minutes.rest.webservices.resfulwebservices.helloworld;

//Rest API
//URI: /hello-world

import org.springframework.web.bind.annotation.*;

@RestController //Adding annotation to make this controlle a rest controller
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world") //Annotation to bind the uri "/hello-world"
    @GetMapping(path = "/hello-world") //Short form of get mapping
    public String helloWorld()
    {
        return "Hello World";
    }

    //Return json
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello World");
    }

    //Path Parameter
    @GetMapping(path = "/hello/path-variables/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello, %s", name));
    }
}
