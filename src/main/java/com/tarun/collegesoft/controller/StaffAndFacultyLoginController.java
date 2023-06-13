package com.tarun.collegesoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.helper.Login;
import com.tarun.collegesoft.service.StaffAndFacultyLoginService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("stafff")
public class StaffAndFacultyLoginController {

    @Autowired
    StaffAndFacultyLoginService service;

    @PostMapping("login")
	public ModelAndView login(Login login, HttpSession session) {
		return service.login(login, session);
	}
}
