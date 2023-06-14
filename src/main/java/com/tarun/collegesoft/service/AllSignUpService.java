package com.tarun.collegesoft.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.FacultyDao;
import com.tarun.collegesoft.dao.StaffDao;
import com.tarun.collegesoft.dto.Faculty;
import com.tarun.collegesoft.dto.Staff;

@Service
public class AllSignUpService {


    @Autowired
    FacultyDao facultyDao;

	@Autowired
	StaffDao staffDao;

    public ModelAndView signup(Faculty faculty, String date) {
        ModelAndView view = new ModelAndView();
        if (facultyDao.fetch(faculty.getEmail()) == null && facultyDao.fetch(faculty.getMobile()) == null) {
			Date dob = Date.valueOf(date);
			faculty.setDob(dob);
			int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
			faculty.setAge(age);

			facultyDao.save(faculty);
			view.setViewName("FacultyHome");
			view.addObject("success", "Faculty Account created Success");
		} else {
			view.setViewName("FacultySignup");
			view.addObject("fail", "Email or Phone already Exists");
		}
		return view;
    }


    public ModelAndView signup(Staff staff, String date) {
        ModelAndView view = new ModelAndView();
		if (staffDao.fetch(staff.getEmail()) == null && staffDao.fetch(staff.getMobile()) == null) {
			Date dob = Date.valueOf(date);
			staff.setDob(dob);
			int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
			staff.setAge(age);

			staffDao.save(staff);
			view.setViewName("StaffHome");
			view.addObject("success", "Staff Account created Success");
		} else {
			view.setViewName("StaffSignup");
			view.addObject("fail", "Email or Phone already Exists");
		}
		return view;
    }
    
}
