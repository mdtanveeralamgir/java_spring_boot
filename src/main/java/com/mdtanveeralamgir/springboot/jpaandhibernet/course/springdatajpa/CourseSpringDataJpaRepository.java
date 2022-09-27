package com.mdtanveeralamgir.springboot.jpaandhibernet.course.springdatajpa;

import com.mdtanveeralamgir.springboot.jpaandhibernet.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> { //This JpaRepository makes it a spring data jpa repository

    //Just need to extend this JpaRepository class
    //All the methods will be available from that class
}
