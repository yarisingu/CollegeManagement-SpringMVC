package com.tarun.collegesoft.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tarun.collegesoft.dao.FacultyDao;




@Service
public class FacultyService {
	@Autowired
	FacultyDao facultyDao;

	

}
