package com.tarun.collegesoft.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tarun.collegesoft.dto.Faculty;
import com.tarun.collegesoft.repository.FacultyRepository;

@Repository
public class FacultyDao {
    
	@Autowired
	FacultyRepository repository;

	public void save(Faculty faculty) {
		repository.save(faculty);
	}

	public Faculty fetch(String email) {
		return repository.findByEmail(email);
	}

	public Faculty fetch(long mobile) {
		return repository.findByMobile(mobile);
	}

	public Optional<Faculty> fetch(int id)
	{
		return repository.findById(id);
	}
}
