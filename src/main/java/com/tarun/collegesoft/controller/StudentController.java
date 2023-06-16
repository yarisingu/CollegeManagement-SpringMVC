package com.tarun.collegesoft.controller;



import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dto.Student;
import com.tarun.collegesoft.helper.Login;
import com.tarun.collegesoft.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping("signup")
	public ModelAndView signup(@ModelAttribute Student student, @RequestParam MultipartFile pic,@RequestParam String date) throws IOException {
		return studentService.signup(student, date,pic);
	}

	@PostMapping("login")
	public ModelAndView login(@ModelAttribute Login login, HttpSession session) {
		return studentService.login(login, session);
	}

	@GetMapping("course")
	public ModelAndView fetchStaff() {
		return studentService.fetchCourse();
	}

	@PostMapping("enroll")
	public ModelAndView enroll(@RequestParam String course, @RequestParam String stream, HttpSession session) {
		return studentService.enroll(course, stream, session);
	}
	
	@GetMapping("accept")
	public ModelAndView accept(HttpSession session)
	{
		return studentService.accept(session);
	}
	
	@GetMapping("reject")
	public ModelAndView reject(HttpSession session)
	{
		return studentService.reject(session);
	}
	
	@GetMapping("approve/{id}")
	public ModelAndView approve(@PathVariable int id)
	{
		return studentService.approveStudent(id);
	}
}