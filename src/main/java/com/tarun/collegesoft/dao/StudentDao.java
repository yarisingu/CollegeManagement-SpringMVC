package com.tarun.collegesoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tarun.collegesoft.dto.Student;
import com.tarun.collegesoft.repository.StudentRepository;

@Repository
public class StudentDao {
	
	@Autowired
	StudentRepository repository;

	public void save(Student student) {
		repository.save(student);
	}

	public Student fetch(String email) {
		return repository.findByEmail(email);
	}

	public Student fetch(long mobile) {
		return repository.findByMobile(mobile);
	}

}
