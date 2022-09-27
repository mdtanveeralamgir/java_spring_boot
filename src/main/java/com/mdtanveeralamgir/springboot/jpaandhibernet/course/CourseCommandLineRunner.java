package com.mdtanveeralamgir.springboot.jpaandhibernet.course;

import com.mdtanveeralamgir.springboot.jpaandhibernet.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.mdtanveeralamgir.springboot.jpaandhibernet.course.jpa.CourseJpaRepository;

@Component //Spring can find it in component scan
public class CourseCommandLineRunner implements CommandLineRunner{ //the interface makes this class running at startup

//	@Autowired
//	private CourseJpaRepository repository;
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		this.repository.save(new Course(1, "Aayid", "mta"));
		this.repository.save(new Course(2, "Shamma", "mta"));
		this.repository.save(new Course(3, "Opel", "mta"));
		this.repository.save(new Course(4, "Ope", "mta"));
		this.repository.deleteById(1l);
//		System.out.println(this.repository.findById(3l));
		this.repository.findAll().stream().filter(course -> course.getName().length() >= 3 ).forEach(System.out::println);
//		System.out.println(this.repository.count());
//		System.out.println(this.repository.findByAuthor("mta"));

	} 

	
}
