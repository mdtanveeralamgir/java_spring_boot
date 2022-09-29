package com.in28minutes.rest.webservices.resfulwebservices.user;

import com.in28minutes.rest.webservices.resfulwebservices.jpa.PostRepository;
import com.in28minutes.rest.webservices.resfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController //making it a rest controller
public class UserJpaResource {
    private UserRepository repository;
    private PostRepository postRepository;

    //Constructor injection
    public UserJpaResource(UserRepository repository, PostRepository postRepository)
    {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    //GET /users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers()
    {
        return this.repository.findAll();
    }

    /*
     * Adding link to all users
     * Link to add: http://localhost:8080/users
     * 2 concepts to add link to the date:
     * EntityModel: Allows to add the link in the User bean (class user) without changing the User bean
     * WebMvcLinkBuilder
     */
    //Get a single user
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id)
    {
        Optional<User> user =  this.repository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundExceltion("id:"+id);

        //Creating an entitymodel of user
        EntityModel<User> entityModel = EntityModel.of(user.get());
        
        //Needs to import the methodOn manually
        //Adding the link using WebMvcLinkBuilder
        //Linking to this class's controller method and calling retrieveAllUsers method
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users")); //Adding the link to entityModel and giving it a name
        
        return entityModel;
    }

    //Create a new user
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) //The content of a user is sent as a part of the request body hence @RequestBody annotation
    {
       User savedUser = this.repository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()//path of the current request
                .path("/{id}")//Append the variable into the current variable
                .buildAndExpand(savedUser.getId()) //Replacing the variable with newly added userId
                .toUri(); //Converting into uri obj

        // ResponseEntity is a build in class of spring to send correct http code
       return ResponseEntity.created(location).build();
    }

    //Delete a user
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        this.repository.deleteById(id);
    }
    //Fetch post for a user
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id)
    {
        //First needs to find the user
        Optional<User> user =  this.repository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundExceltion("id:"+id);

        return user.get().getPosts();
    }

    //create post for a user
    @PostMapping("/jpa/users/{id}/post")
    public void createPostForUser(@PathVariable int id, @Valid @RequestBody Post post)
    {
        //First needs to find the user
        Optional<User> user =  this.repository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundExceltion("id:"+id);
        post.setUser(user.get());
        postRepository.save(post);
    }

}
