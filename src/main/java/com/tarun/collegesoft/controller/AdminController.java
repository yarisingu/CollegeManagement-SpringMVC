package com.tarun.collegesoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dto.Cources;
import com.tarun.collegesoft.helper.Login;
import com.tarun.collegesoft.service.AdminService;
import com.tarun.collegesoft.service.CourcesService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@Autowired
	CourcesService courceservice;
	
	@GetMapping("login")
	public ModelAndView loadAdmin()
	{
		return adminservice.laodAdmin();
	}
	
	@PostMapping("login")
	public ModelAndView login(@ModelAttribute Login login , HttpSession session)
	{
		return adminservice.login(login,session);
	}
	
	@GetMapping("course")
	public ModelAndView loadCources()
	{
		return courceservice.load();
	}
	
	@PostMapping("course")
	public ModelAndView Addcource(@ModelAttribute  Cources course)
	{
		return courceservice.add(course);
	}
	@GetMapping("stream")
	public ModelAndView loadstream()
	{
		return courceservice.loadStream();
	}
	
	
}
