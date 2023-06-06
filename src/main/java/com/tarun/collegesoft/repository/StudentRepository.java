package com.tarun.collegesoft.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tarun.collegesoft.dto.Student;



public interface StudentRepository  extends JpaRepository<Student, Integer> {

	Student findByEmail(String email);

	Student findByMobile(long mobile);

	@Query("select x from Student x where status=true and doj=null")
	List<Student> fetchAllApprovedStudents();

}
