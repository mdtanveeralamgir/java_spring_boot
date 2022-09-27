package com.mdtanveeralamgir.springboot.jpaandhibernet.course.springdatajpa;

import com.mdtanveeralamgir.springboot.jpaandhibernet.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> { //This JpaRepository makes it a spring data jpa repository

    //Just need to extend this JpaRepository class
    //All the methods will be available from that class

    //customized methods

    //Return a list of course filtered by author
    //The naming convention needs to be followed findBy + name of the column
    List<Course> findByAuthor(String author);
}
