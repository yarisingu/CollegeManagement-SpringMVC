package com.tarun.collegesoft.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dto.Staff;
import com.tarun.collegesoft.service.StaffService;


@Controller
@RequestMapping("staff")
public class StaffController {
	@Autowired
	StaffService staffService;




}