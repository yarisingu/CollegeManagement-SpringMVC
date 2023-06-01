package com.tarun.collegesoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class Maincontroller {
	
	@GetMapping("/")
	public ModelAndView homePage() {
		ModelAndView view = new ModelAndView("/Home");
		return view;
	}

	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView view = new ModelAndView("Home");
		view.addObject("fail", "Logged out Successfully");
		return view;
	}

}
