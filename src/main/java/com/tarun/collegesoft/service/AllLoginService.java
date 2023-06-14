package com.tarun.collegesoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.FacultyDao;
import com.tarun.collegesoft.dao.StaffDao;
import com.tarun.collegesoft.dto.Faculty;
import com.tarun.collegesoft.dto.Staff;
import com.tarun.collegesoft.helper.Login;

import jakarta.servlet.http.HttpSession;

@Service
public class AllLoginService{

    @Autowired
	FacultyDao facultyDao;

    @Autowired
	StaffDao staffDao;

    // this is for faculty and staff login method
    public ModelAndView login(Login login, HttpSession session) {
        ModelAndView view = new ModelAndView();

        // this block is used for faculty
         if (login.getId() > 100000 && login.getId() < 199999)
       {
            Optional<Faculty> faculty = facultyDao.fetch(login.getId());
            if(faculty != null)
            {
                if( faculty.get().getPassword().equals(login.getPassword()) )
                {
                    session.setAttribute("faculty", "faculty");
                    view.setViewName("FacultyHome");
                    view.addObject("sucess", "Login sucess ");
                }
                else{
                    view.setViewName("Login");
                    view.addObject("fail", "password is worng ");
                }
                
            }
            else{
                view.setViewName("Login");
                    view.addObject("fail", "employee id was worng ");
            }
       }



       // this block is used for staff 
        if (login.getId() > 200001 && login.getId() < 299999)
       {
             Optional<Staff> staff = staffDao.fetch(login.getId());
            if(staff.isPresent())
            {
                if(staff.get().getPassword().equals(login.getPassword()))
                {
                    session.setAttribute("staff", "faculty");
                    view.setViewName("FacultyHome");
                    view.addObject("sucess", "Login sucess ");
                }
                else{
                    view.setViewName("Login");
                    view.addObject("fail", "password is worng ");
                }
                
            }
            else{
                view.setViewName("Login");
                    view.addObject("fail", "employee id was worng ");
            }
       }
        return null;
    }


    // This is admin login block
    public ModelAndView adminLogin(Login login, HttpSession session) {
        ModelAndView view = new ModelAndView();
		if (login.getEmail().equals("admin")) {
			if (login.getPassword().equals("admin")) {
				session.setAttribute("admin", "admin");
				view.setViewName("AdminHome");
				view.addObject("success", " Login Success");
			} else {
				view.setViewName("Login");
				view.addObject("fail", "Admin Password Wrong");
			}
		} else {
			view.setViewName("Login");
			view.addObject("fail", " Admin Email Wrong");
		}

		return view;
        
    }
     
}
