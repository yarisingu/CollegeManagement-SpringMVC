package com.tarun.collegesoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.collegesoft.dto.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    Faculty findByEmail(String email);

	Faculty findByMobile(long mobile);
    
}
