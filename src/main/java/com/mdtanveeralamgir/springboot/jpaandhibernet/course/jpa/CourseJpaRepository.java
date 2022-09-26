package com.mdtanveeralamgir.springboot.jpaandhibernet.course.jpa;

import org.springframework.stereotype.Repository;

import com.mdtanveeralamgir.springboot.jpaandhibernet.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository //Making it a repository to talk to db
@Transactional
public class CourseJpaRepository {

	// Autowire will work but persistanceContext is more accurate for entity
	// @Autowired
	@PersistenceContext
	private EntityManager entityManager; //Spring entity manager to manage entity
	
	//Inserting into courser table
	public void insert(Course course)
	{
		entityManager.merge(course);
	}
	
	public Course findById(long id)
	{
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id)
	{
		Course course = findById(id);
		entityManager.remove(course);
	}
}
