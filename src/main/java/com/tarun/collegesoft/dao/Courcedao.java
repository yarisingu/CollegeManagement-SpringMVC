package com.tarun.collegesoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tarun.collegesoft.dto.Cources;
import com.tarun.collegesoft.repository.CourseRepository;


@Repository
public class Courcedao {
	
	@Autowired
	CourseRepository courserepo;

	public void add(Cources corces) {
		
		courserepo.save(corces);
	}
	
	public Cources fetch(String name)
	{
		return courserepo.findByName(name);
	}
	
	
	

}
