package com.tarun.collegesoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.collegesoft.dto.StudentDto;

public interface StudentRepository extends JpaRepository<StudentDto, Integer> {

	

	StudentDto findByEmail(String email);

	StudentDto findByMobile(long mobile);

}
