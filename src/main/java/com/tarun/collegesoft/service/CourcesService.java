package com.tarun.collegesoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.Courcedao;
import com.tarun.collegesoft.dto.Cources;
import com.tarun.collegesoft.dto.Streamdto;

@Service
public class CourcesService {

	@Autowired
	Cources corces;
	
	@Autowired 
	Streamdto stream;
	
	@Autowired
	Courcedao coursedao;
	
	public ModelAndView load() {
		ModelAndView view = new ModelAndView("Addcources");
		view.addObject("course",corces);
		return view;
	}
	
	
	public ModelAndView add(Cources corces)
	{
		ModelAndView view = new ModelAndView("Home");
		Cources corces1 =  coursedao.fetch(corces.getCname());
		if(corces1==null)
		{
		coursedao.add(corces);
		view.addObject("msg","Course Added Successfully");
		}else {
			view.addObject("msg",corces.getCname()+" Course Already Exists");
		}	
		return view;       
	}


	public ModelAndView loadStream() {
		ModelAndView view = new ModelAndView("AddStream");
		view.addObject("stream",stream);
		return view;
	}
	
	
	
	

}
