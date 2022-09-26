// this class will talk to the db tables
// running queries
package com.mdtanveeralamgir.springboot.jpaandhibernet.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mdtanveeralamgir.springboot.jpaandhibernet.course.Course;

@Repository //Makding this class a repo to talk to db
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = 
		"""
			insert into course (id, name, author) 
			values (?, ?, ?);
	
		""";
	private static String DELETE_QUERY = 
			"""
				DELETE FROM course where id = ?;
		
			""";
	
	public void insert(Course course)
	{
		this.springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long id)
	{
		this.springJdbcTemplate.update(DELETE_QUERY, id);
	}

}
