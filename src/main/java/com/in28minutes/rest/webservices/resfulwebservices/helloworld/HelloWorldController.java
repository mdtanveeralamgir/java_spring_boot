package com.in28minutes.rest.webservices.resfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

//Rest API
//URI: /hello-world

import org.springframework.web.bind.annotation.*;

@RestController //Adding annotation to make this controlle a rest controller
public class HelloWorldController {
	
	
	//Getting use of MessageSource from springboot
	private MessageSource messageSource;
	
	//Constructor injection for messageSource
	public HelloWorldController(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}

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
    
    //Internationalized (get the response in different language)
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized()
    {
    	//Getting the Locale from request header
    	//Returns the locale associated with current thread or use the default locale
    	Locale locale = LocaleContextHolder.getLocale();
    	
    	return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
        
        
        // 1: Define the messages in different language
        // 2: And then pick up when requested
        /*
         * for en - (Good Morning)
         * for fr - (Bonjour)
         */
    }
}
