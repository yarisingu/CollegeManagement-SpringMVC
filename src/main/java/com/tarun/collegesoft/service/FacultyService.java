package com.tarun.collegesoft.service;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.FacultyDao;
import com.tarun.collegesoft.dto.Faculty;
import com.tarun.collegesoft.helper.Login;

import jakarta.servlet.http.HttpSession;

@Service
public class FacultyService {
	@Autowired
	FacultyDao facultyDao;

	public ModelAndView signup(Faculty faculty, String date, MultipartFile pic) throws IOException {
		ModelAndView view = new ModelAndView();
		if (facultyDao.fetch(faculty.getEmail()) == null && facultyDao.fetch(faculty.getMobile()) == null) {
			Date dob = Date.valueOf(date);
			faculty.setDob(dob);
			int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
			faculty.setAge(age);
			byte[] picture = null;
			if (pic != null) {
				InputStream inputStream = pic.getInputStream();
				picture = new byte[inputStream.available()];
				inputStream.read(picture);
			}
			faculty.setPicture(picture);
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
				if (faculty.isStatus()) {
					session.setAttribute("faculty", "faculty");
					view.setViewName("FacultyHome");
					view.addObject("success", "Login Success");
				} else {
					view.setViewName("FacultyLogin");
					view.addObject("fail", "Wait for Admin Approval");
				}
			} else {
				view.setViewName("FacultyLogin");
				view.addObject("fail", "Password Wrong");
			}
		}

		return view;
	}

	public ModelAndView fetchAll() {
		ModelAndView view = new ModelAndView();
		List<Faculty> list = facultyDao.fetch();
		if (list.isEmpty()) {
			view.addObject("fail", "No Faculty Registered Yet");
			view.setViewName("AdminHome");
		} else {
			view.addObject("list", list);
			view.setViewName("ApproveFaculty");
		}
		return view;
	}

	public ModelAndView changeStatus(int id) {
		ModelAndView view = new ModelAndView();

		Faculty faculty = facultyDao.fetchById(id);
		if (faculty.isStatus())
			faculty.setStatus(false);
		else
			faculty.setStatus(true);

		view.addObject("list", facultyDao.fetch());
		view.setViewName("ApproveFaculty");
		return view;
	}


}
