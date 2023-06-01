package com.tarun.collegesoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tarun.collegesoft.dto.StudentDto;
import com.tarun.collegesoft.repository.StudentRepository;

@Repository
public class StudentDao {
	
	@Autowired
	StudentRepository repository;

	public void save(StudentDto student) {
		repository.save(student);
	}

	public StudentDto fetch(String email) {
		return repository.findByEmail(email);
	}

	public StudentDto fetch(long mobile) {
		return repository.findByMobile(mobile);
	}
}
