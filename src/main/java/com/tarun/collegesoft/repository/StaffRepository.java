package com.tarun.collegesoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.collegesoft.dto.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{
    
    Staff findByEmail(String email);

	Staff findByMobile(long mobile);
}
