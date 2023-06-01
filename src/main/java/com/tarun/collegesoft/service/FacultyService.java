package com.tarun.collegesoft.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.FacultyDao;
import com.tarun.collegesoft.dto.Faculty;
import com.tarun.collegesoft.helper.Login;

import jakarta.servlet.http.HttpSession;



@Service
public class FacultyService {

	@Autowired
	FacultyDao facultyDao;

	public ModelAndView signup(Faculty faculty, String date) {
		ModelAndView view = new ModelAndView();
		if (facultyDao.fetch(faculty.getEmail()) == null && facultyDao.fetch(faculty.getMobile()) == null) {
			Date dob = Date.valueOf(date);
			faculty.setDob(dob);
			int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
			faculty.setAge(age);

			facultyDao.save(faculty);
			view.setViewName("Home");
			view.addObject("success", "Faculty Account created Success");
		} else {
			view.setViewName("FacultySignup");
			view.addObject("fail", "Email or Phone already Exists");
		}
		return view;
	}

	public ModelAndView login(Login login, HttpSession session) {
		ModelAndView view = new ModelAndView();
		Faculty faculty = facultyDao.fetch(login.getEmail());
		if (faculty == null) {
			view.setViewName("FacultyLogin");
			view.addObject("fail", "Email Wrong");
		} else {
			if (login.getPassword().equals(faculty.getPassword())) {
				session.setAttribute("faculty", "faculty");
				view.setViewName("FacultyHome");
				view.addObject("success", "Login Success");
			} else {
				view.setViewName("FacultyLogin");
				view.addObject("fail", "Password Wrong");
			}
		}

		return view;
	}

    
}
