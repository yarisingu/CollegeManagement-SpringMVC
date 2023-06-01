package com.tarun.collegesoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dto.Faculty;
import com.tarun.collegesoft.helper.Login;
import com.tarun.collegesoft.service.FacultyService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("faculty")
public class FacultyController {

	@Autowired
	FacultyService facultyService;

	@PostMapping("signup")
	public ModelAndView signup(@ModelAttribute Faculty faculty, @RequestParam String date) {
		return facultyService.signup(faculty, date);
	}

	@PostMapping("login")
	public ModelAndView login(@ModelAttribute Login login, HttpSession session) {
		return facultyService.login(login, session);
	}
}
