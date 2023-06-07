package com.tarun.collegesoft.service;


import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.StaffDao;
import com.tarun.collegesoft.dto.Staff;
import com.tarun.collegesoft.helper.Login;

import jakarta.servlet.http.HttpSession;

@Service
public class StaffService {
	@Autowired
	StaffDao staffDao;

	public ModelAndView signup(Staff staff, String date) {
		ModelAndView view = new ModelAndView();
		if (staffDao.fetch(staff.getEmail()) == null && staffDao.fetch(staff.getMobile()) == null) {
			Date dob = Date.valueOf(date);
			staff.setDob(dob);
			int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
			staff.setAge(age);

			staffDao.save(staff);
			view.setViewName("Home");
			view.addObject("success", "Staff Account created Success");
		} else {
			view.setViewName("StaffSignup");
			view.addObject("fail", "Email or Phone already Exists");
		}
		return view;
	}

	public ModelAndView login(Login login, HttpSession session) {
		ModelAndView view = new ModelAndView();
		Staff staff = staffDao.fetch(login.getEmail());
		if (staff == null) {
			view.setViewName("StaffLogin");
			view.addObject("fail", "Email Wrong");
		} else {
			if (login.getPassword().equals(staff.getPassword())) {
				session.setAttribute("staff", "staff");
				view.setViewName("StaffHome");
				view.addObject("success", "Login Success");
			} else {
				view.setViewName("StaffLogin");
				view.addObject("fail", "Password Wrong");
			}
		}

		return view;
	}
}