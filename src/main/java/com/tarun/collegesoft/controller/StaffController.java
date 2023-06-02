package com.tarun.collegesoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dto.Staff;
import com.tarun.collegesoft.helper.Login;
import com.tarun.collegesoft.service.StaffService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("staff")
public class StaffController{

    @Autowired
	StaffService staffService;

	@PostMapping("signup")
	public ModelAndView signup(@ModelAttribute Staff staff, @RequestParam String date) {
		return staffService.signup(staff, date);
	}

	@PostMapping("login")
	public ModelAndView login(@ModelAttribute Login login, HttpSession session) {
		return staffService.login(login, session);
	}

}