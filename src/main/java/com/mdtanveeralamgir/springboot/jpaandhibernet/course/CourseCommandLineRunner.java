package com.mdtanveeralamgir.springboot.jpaandhibernet.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.mdtanveeralamgir.springboot.jpaandhibernet.course.jpa.CourseJpaRepository;

@Component //Spring can find it in component scan
public class CourseCommandLineRunner implements CommandLineRunner{ //the interface makes this class running at startup

	@Autowired
	private CourseJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		this.repository.insert(new Course(1, "Aayid", "mta"));
		this.repository.insert(new Course(2, "Shamma", "mta"));
		this.repository.insert(new Course(3, "Opel", "mta"));
		this.repository.deleteById(1);
		System.out.println(this.repository.findById(3));
		
	} 

	
}
