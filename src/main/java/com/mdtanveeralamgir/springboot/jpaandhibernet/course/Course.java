package com.mdtanveeralamgir.springboot.jpaandhibernet.course;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity //Making this bean an entity to link with the table "Course" in db
public class Course {
	
	@Id //Primary key
	private long id;
	
	@Column(name="name") //Not necessary if the column name is same as property name
	private String name;
	
	@Column(name="author")
	private String author;
	
	public Course()
	{}
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}
	
	

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
	
	
}
