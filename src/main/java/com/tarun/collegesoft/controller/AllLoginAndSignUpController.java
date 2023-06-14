package com.tarun.collegesoft.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dto.Faculty;
import com.tarun.collegesoft.dto.Staff;
import com.tarun.collegesoft.helper.Login;
import com.tarun.collegesoft.service.AllLoginService;
import com.tarun.collegesoft.service.AllSignUpService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AllLoginAndSignUpController {

    @Autowired
    AllLoginService loginService;

	@Autowired
	AllSignUpService SignUpService;

    @PostMapping("alllogin")
		public ModelAndView login(Login login, HttpSession session) {
		return loginService.login(login, session);
	}

     @PostMapping("adminlogin")
		public ModelAndView adminLogin(Login login, HttpSession session) {
		return loginService.adminLogin(login, session);
	}


	@GetMapping("/adminnlogout")
		public void adminLogout(HttpSession session, HttpServletResponse servlet) throws IOException  {
		session.invalidate();
		servlet.sendRedirect("/index.html");
	}


		@PostMapping("facultysignup")
		public ModelAndView signup(@ModelAttribute Faculty faculty, @RequestParam String date) {
		return SignUpService.signup(faculty, date);
	}


		@PostMapping("staffsignup")
		public ModelAndView signup(@ModelAttribute Staff staff, @RequestParam String date) {
		return SignUpService.signup(staff, date);
	}
}
