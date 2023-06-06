package com.tarun.collegesoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.CourseDao;
import com.tarun.collegesoft.dto.Course;
import com.tarun.collegesoft.dto.Stream;

@Service
public class CourseService {

	@Autowired
	CourseDao courseDao;

	public ModelAndView add(Course course) {
		ModelAndView view = new ModelAndView();

		Course course2 = courseDao.fetch(course.getName());
		if (course2 == null) {
			courseDao.add(course);
			view.setViewName("Home");
			view.addObject("success", "Course Added Successfully");
		} else {
			view.setViewName("AddCourse");
			view.addObject("fail", course.getName() + " Course Already Exists");
		}
		return view;
	}

	public ModelAndView checkCourse() {
		ModelAndView view = new ModelAndView();

		List<Course> list = courseDao.fetch();
		if (list.isEmpty()) {
			view.setViewName("/AdminHome");
			view.addObject("fail", "First Add Course");
		} else {
			view.setViewName("AddStream");
			view.addObject("list", list);
		}
		return view;
	}

	public ModelAndView saveStream(Stream stream, String courseName) {
		ModelAndView view = new ModelAndView();

		

		Course course = courseDao.fetch(courseName);
		List<Stream> streams = course.getStreams();
		if (streams == null) {
			streams = new ArrayList<Stream>();
		}
		boolean flag = true;
		for (Stream s : streams) {
			if (s.getName().equalsIgnoreCase(stream.getName())) {
				flag = false;
			}
		}
		if (flag) {
			streams.add(stream);
			course.setStreams(streams);
			courseDao.add(course);
			view.setViewName("Home");
			view.addObject("success", "Stream Added Success");
		} else {
			List<Course> list = courseDao.fetch();
			view.addObject("list", list);
			view.addObject("fail", "Stream " + stream.getName() + " already exists in the course " + courseName + "");
			view.setViewName("AddStream");
		}
		return view;
	}



	
}
