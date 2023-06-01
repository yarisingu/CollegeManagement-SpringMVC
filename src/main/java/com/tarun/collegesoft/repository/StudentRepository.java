package com.tarun.collegesoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.collegesoft.dto.Student;



public interface StudentRepository  extends JpaRepository<Student, Integer> {

	Student findByEmail(String email);

	Student findByMobile(long mobile);

}
