package com.tarun.collegesoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.Courcedao;
import com.tarun.collegesoft.dto.Cources;
import com.tarun.collegesoft.dto.Streamdto;

@Service
public class CourcesService {

	@Autowired
	Courcedao coursedao;
	
	public ModelAndView add(Cources corces)
	{
		ModelAndView view = new ModelAndView("Home");
		Cources corces1 =  coursedao.fetch(corces.getName());
		if(corces1==null)
		{
			coursedao.add(corces);
			view.addObject("success","Course Added Successfully");
		}else {
			view.addObject("fail",corces.getName()+" Course Already Exists");
		}	
		return view;       
	}

	public ModelAndView checkCourse() {
		ModelAndView view = new ModelAndView();

		List<Cources> list = coursedao.fetch();
		if (list.isEmpty()) {
			view.setViewName("Home");
			view.addObject("fail", "First Add Course");
		} else {
			view.setViewName("AddStream");
			view.addObject("list", list);
		}
		return view;
	}

	public ModelAndView saveStream(Streamdto stream, String courseName) {
		ModelAndView view=new ModelAndView();
		
		Cources course = coursedao.fetch(courseName);
		List<Streamdto> streams = course.getStreams();
		if (streams == null) {
			
			streams = new ArrayList<Streamdto>();
		}
		boolean flag=true;
		for(Streamdto s:streams)
		{
			if(s.getName().equalsIgnoreCase(stream.getName()))
			{
				flag=false;
			}
		}
		if(flag)
		{
			streams.add(stream);
			course.setStreams(streams);
			coursedao.add(course);
			view.setViewName("Home");
			view.addObject("success","Stream Added Success");
		}
		else {
			List<Cources> list = coursedao.fetch();
			view.addObject("list", list);
			view.addObject("fail","Stream "+stream.getName()+" already exists in the course "+courseName+"");
			view.setViewName("AddStream");
		}
		return view;
	}




	
}
