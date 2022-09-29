package com.in28minutes.rest.webservices.resfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity(name = "user_details") //User is a keywork in h2, so table name needs to be different than class name user
public class User {

    protected User(){}
    @Id
    @GeneratedValue //Auto generated
    private int id;
    
    @Size(min=2, message = "Name should have at least 2 characters.") //"Jakarta" validation min length 3
    @JsonProperty("user_name") //response would show "user_name" instead of "name"
    private String name;
    
    @Past(message = "Birth date should always be in the past") //The date should be past date from jakarta validation package
    @JsonProperty("Birth_Date")
    private LocalDate birthDate;

    //One to many relation, linked with the user property in Post
    //Means the owner of this relationship is user
    //Also this will create a column with user_id in the post table
    @OneToMany(mappedBy = "user")
    @JsonIgnore //Do not need to get the post when search for a user
    private List<Post> posts;
    public User(int Id, String name, LocalDate birthDate)
    {
        this.id = Id;
        this.name = name;
        this.birthDate = birthDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
