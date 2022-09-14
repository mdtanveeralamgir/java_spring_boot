package com.in28minutes.rest.webservices.resfulwebservices.user;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

//Importing all methods of WebMvcLinkBuilder manually to use the methodOn method
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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

    /*
     * Adding link to all users
     * Link to add: http://localhost:8080/users
     * 2 concepts to add link to the date:
     * EntityModel: Allows to add the link in the User bean (class user) without changing the User bean
     * WebMvcLinkBuilder
     */
    //Get a single user
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id)
    {
        User user =  this.service.findOne(id);

        if(user == null)
            throw new UserNotFoundExceltion("id:"+id);

        //Creating an entitymodel of user
        EntityModel<User> entityModel = EntityModel.of(user);
        
        //Needs to import the methodOn manually
        //Adding the link using WebMvcLinkBuilder
        //Linking to this class's controller method and calling retrieveAllUsers method
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users")); //Adding the link to entityModel and giving it a name
        
        return entityModel;
    }

    //Create a new user
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) //The content of a user is sent as a part of the request body hence @RequestBody annotation
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

    //Delete a user
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        this.service.deleteById(id);
    }

}
