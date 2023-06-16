package com.tarun.collegesoft.dao;

import java.util.List;
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

	public List<Faculty> fetch() {
		return repository.findAll();
	}

	public Faculty fetchById(int id) {
		Optional<Faculty> op = repository.findById(id);
		if (op.isPresent())
			return op.get();
		else
			return null;
	}
}
