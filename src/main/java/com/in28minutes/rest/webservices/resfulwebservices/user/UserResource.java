package com.in28minutes.rest.webservices.resfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<User> createUser(@RequestBody User user) //The content of a user is sent as a part of the request body hence @RequestBody annotation
    {
       User savedUser = this.service.saveUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()//path of the current request
                .path("/{id}")//Append the variable into the current variable
                .buildAndExpand(savedUser.getId()) //Replacing the variable with newly added userId
                .toUri(); //Converting into uri obj

        // ResponseEntity is a build in class of spring to send correct http code
       return ResponseEntity.created(location).build();
    }

}
