package com.tarun.collegesoft.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tarun.collegesoft.dto.Staff;
import com.tarun.collegesoft.repository.StaffRepository;

@Repository
public class StaffDao {

	@Autowired
	StaffRepository repository;

	public void save(Staff staff) {
		repository.save(staff);
	}

	public Staff fetch(String email) {
		return repository.findByEmail(email);
	}

	public Staff fetch(long mobile) {
		return repository.findByMobile(mobile);
	}

	public List<Staff> fetch() {
		return repository.findAll();
	}

	public Staff fetchById(int id) {
		Optional<Staff> op = repository.findById(id);
		if (op.isPresent())
			return op.get();
		else
			return null;
	}
}
