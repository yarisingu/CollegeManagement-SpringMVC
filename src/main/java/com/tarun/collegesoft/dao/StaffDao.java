package com.tarun.collegesoft.dao;

import org.springframework.stereotype.Repository;

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
}
