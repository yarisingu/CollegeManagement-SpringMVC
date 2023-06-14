package com.tarun.collegesoft.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tarun.collegesoft.service.FacultyService;



@Controller
@RequestMapping("faculty")
public class FacultyController {
	@Autowired
	FacultyService facultyService;


}