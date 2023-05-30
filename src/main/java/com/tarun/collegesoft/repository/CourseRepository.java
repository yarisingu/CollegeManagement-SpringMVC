package com.tarun.collegesoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.collegesoft.dto.Cources;

public interface CourseRepository extends JpaRepository<Cources, Integer> {

	Cources findByCname(String cname);

}
