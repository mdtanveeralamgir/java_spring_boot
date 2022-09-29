package com.in28minutes.rest.webservices.resfulwebservices.jpa;


import com.in28minutes.rest.webservices.resfulwebservices.user.Post;
import com.in28minutes.rest.webservices.resfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
