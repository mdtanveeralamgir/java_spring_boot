package com.mdtanveeralamgir.springboot.jpaandhibernet.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mdtanveeralamgir.springboot.jpaandhibernet.course.Course;

@Component //Spring can find it in component scan
public class CourseJdbcCommandLineRunner implements CommandLineRunner{ //the interface makes this class running at startup

	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		this.repository.insert(new Course(1, "Aayid", "mta"));
		this.repository.insert(new Course(2, "Shamma", "mta"));
		this.repository.insert(new Course(3, "Opel", "mta"));
		this.repository.deleteById(1);
		
	} 

	
}
