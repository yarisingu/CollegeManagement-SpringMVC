package com.tarun.collegesoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tarun.collegesoft.dto.Course;
import com.tarun.collegesoft.repository.CourseRepository;


@Repository
public class CourseDao {
	
	@Autowired
	CourseRepository repository;

	public void add(Course course) {
		repository.save(course);
	}

	public Course fetch(String name) {
		return repository.findByName(name);
	}

	public List<Course> fetch() {
		return repository.findAll();
	}


}
