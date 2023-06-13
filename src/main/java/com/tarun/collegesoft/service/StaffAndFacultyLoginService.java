package com.tarun.collegesoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.FacultyDao;
import com.tarun.collegesoft.dao.StaffDao;
import com.tarun.collegesoft.dto.Faculty;
import com.tarun.collegesoft.helper.Login;

import jakarta.servlet.http.HttpSession;

@Service
public class StaffAndFacultyLoginService {

    @Autowired
	FacultyDao facultyDao;

    @Autowired
	StaffDao staffDao;

    public ModelAndView login(Login login, HttpSession session) {
        ModelAndView view = new ModelAndView();

        // this block is used for faculty
         if (login.getId() > 100001 && login.getId() < 199999)
       {
            Optional<Faculty> faculty = facultyDao.fetch(login.getId());
            if(faculty.isPresent())
            {
                if(faculty.get().getPassword().equals(login.getPassword()) )
                {
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
             Optional<Faculty> faculty = facultyDao.fetch(login.getId());
            if(faculty.isPresent())
            {
                if(faculty.get().getPassword().equals(login.getPassword()))
                {
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

   

   
  


    
}
