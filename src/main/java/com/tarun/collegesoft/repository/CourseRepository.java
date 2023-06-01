package com.tarun.collegesoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.collegesoft.dto.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Course findByName(String name);

}
