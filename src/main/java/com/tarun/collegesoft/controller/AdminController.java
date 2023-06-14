package com.tarun.collegesoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dto.Course;
import com.tarun.collegesoft.dto.Stream;
import com.tarun.collegesoft.service.AdminService;
import com.tarun.collegesoft.service.CourseService;
import com.tarun.collegesoft.service.StudentService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentService studentService;

	@PostMapping("course")
	public ModelAndView addCourse(@ModelAttribute Course course) {
		return courseService.add(course);
	}

	@GetMapping("stream")
	public ModelAndView checkCourse() {
		return courseService.checkCourse();
	}

	@PostMapping("stream")
	public ModelAndView saveStream(@ModelAttribute Stream stream, @RequestParam String courseName) {
		return courseService.saveStream(stream, courseName);
	}
	
	@GetMapping("admission")
	public ModelAndView admission()
	{
		return studentService.fetchAllAcceptedStudent();
	}
}