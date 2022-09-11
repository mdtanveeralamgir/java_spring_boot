package com.in28minutes.rest.webservices.resfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //making it a rest controller
public class UserResource {

    private UserDaoService service; //Since UserDaoService is a component of sprint so we can autowire it.

    //Constructor injection
    public UserResource(UserDaoService service)
    {
        this.service = service;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers()
    {
        return this.service.findAll();
    }

    //Get a single user
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id)
    {
        return this.service.findOne(id);
    }

    //Create a new user
    @PostMapping("/users")
    public User createUser(@RequestBody User user) //The content of a user is sent as a part of the request body hence @RequestBody annotation
    {
       return this.service.saveUser(user);
    }

}
