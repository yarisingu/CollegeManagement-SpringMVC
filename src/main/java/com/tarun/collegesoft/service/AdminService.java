package com.tarun.collegesoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.helper.Login;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {
	
	@Autowired
	Login login;

	public ModelAndView laodAdmin() {
		ModelAndView view = new ModelAndView("AdminLogin");
		view.addObject("login",login);
		return view;
	}
	
	public ModelAndView login(Login login, HttpSession session) {
		
		ModelAndView view = new ModelAndView();
		
		if(login.getEmail().equals("admin"))
		{
			if(login.getPasscode().equals("admin"))
			{
				session.setAttribute("admin", "admin");
				view.setViewName("Home");
				 view.addObject("msg","Login scucess");
			}
			else {
				 view.setViewName("AdminLogin");
				 view.addObject("login",login);
				 view.addObject("msg","passcode worng");
			}
		}
		else 
		{
			view.setViewName("AdminLogin");
			view.addObject("login",login);
			view.addObject("msg","Email Wrong");
		}
		return view;
	}
	
}
