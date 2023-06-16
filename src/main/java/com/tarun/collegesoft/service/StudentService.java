package com.tarun.collegesoft.service;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tarun.collegesoft.dao.CourseDao;
import com.tarun.collegesoft.dao.StudentDao;
import com.tarun.collegesoft.dto.Course;
import com.tarun.collegesoft.dto.Stream;
import com.tarun.collegesoft.dto.Student;
import com.tarun.collegesoft.helper.Login;
import com.tarun.collegesoft.helper.SendMail;

import jakarta.servlet.http.HttpSession;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;

	@Autowired
	SendMail sendMail;

	@Autowired
	CourseDao courseDao;

	public ModelAndView signup(Student student, String date, MultipartFile pic) throws IOException {
		ModelAndView view = new ModelAndView();
		if (studentDao.fetch(student.getEmail()) == null && studentDao.fetch(student.getMobile()) == null) {
			Date dob = Date.valueOf(date);
			student.setDob(dob);
			int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
			student.setAge(age);

			byte[] picture = null;
			if (pic != null) {
				InputStream inputStream = pic.getInputStream();
				picture = new byte[inputStream.available()];
				inputStream.read(picture);
			}
			student.setPicture(picture);
			studentDao.save(student);
			view.setViewName("Home");
			view.addObject("success", "Student Account created Success");
		} else {
			view.setViewName("StudentSignup");
			view.addObject("fail", "Email or Phone already Exists");
		}
		return view;
	}

	public ModelAndView login(Login login, HttpSession session) {
		ModelAndView view = new ModelAndView();
		Student student = studentDao.fetch(login.getEmail());
		if (student == null) {
			view.setViewName("StudentLogin");
			view.addObject("fail", "Email Wrong");
		} else {
			if (login.getPassword().equals(student.getPassword())) {
				session.setAttribute("student", student);
				sendMail.send(student);
				view.setViewName("StudentHome");
				view.addObject("success", "Login Success");
			} else {
				view.setViewName("StudentLogin");
				view.addObject("fail", "Password Wrong");
			}
		}

		return view;
	}

	public ModelAndView fetchCourse() {
		ModelAndView view = new ModelAndView();

		List<Course> list = courseDao.fetch();
		if (list.isEmpty()) {
			view.setViewName("StudentHome");
			view.addObject("fail", "No Courses to Opt");
		} else {
			view.setViewName("/EnrollCourse");
			view.addObject("list", list);
		}
		return view;
	}

	public ModelAndView enroll(String course, String stream, HttpSession session) {
		ModelAndView view = new ModelAndView();

		Student student = (Student) session.getAttribute("student");
		Stream stream1 = null;
		Course course1 = courseDao.fetch(course);
		for (Stream stream2 : course1.getStreams()) {
			if (stream2.getName().equals(stream))
				stream1 = stream2;
		}
		if (student.getSslc() > 80 && student.getPuc() > 80) {
			if (stream1.getNseat() > 0) {
				view.addObject("name", student.getName());
				view.addObject("course", course);
				view.addObject("stream", stream);
				view.addObject("quota", "Normal");
				view.addObject("fee", NumberFormat.getInstance().format(course1.getFee() + stream1.getFee()));
				view.setViewName("StudentAdmission");
				student.setQuota("Normal");
				student.setCourse(course1);
				student.setStream(stream1);
				Student student1 = studentDao.save(student);
				session.setAttribute("student", student1);
			} else if (stream1.getMseat() > 0) {
				view.addObject("name", student.getName());
				view.addObject("course", course);
				view.addObject("stream", stream);
				view.addObject("quota", "Management");
				view.addObject("fee", (course1.getFee() + stream1.getFee()) * 2);
				view.setViewName("StudentAdmission");
				student.setQuota("Management");
				student.setCourse(course1);
				student.setStream(stream1);
				Student student1 = studentDao.save(student);
				session.setAttribute("student", student1);
			} else {
				view.setViewName("StudentHome");
				view.addObject("fail",
						"Hello " + student.getName() + " Sorry Seats are Not Availbale in " + course + " " + stream);
			}
		} else {
			if (stream1.getMseat() > 0) {
				view.addObject("name", student.getName());
				view.addObject("course", course);
				view.addObject("stream", stream);
				view.addObject("quota", "Management");
				view.addObject("fee", (course1.getFee() + stream1.getFee()) * 2);
				view.setViewName("StudentAdmission");
				student.setCourse(course1);
				student.setQuota("Management");
				student.setStream(stream1);
				Student student1 = studentDao.save(student);
				session.setAttribute("student", student1);
			} else {
				view.setViewName("StudentHome");
				view.addObject("fail",
						"Hello " + student.getName() + " Sorry Seats are Not Availbale in " + course + " " + stream);
			}
		}
		return view;
	}

	public ModelAndView accept(HttpSession session) {
		ModelAndView view = new ModelAndView("StudentHome");
		Student student = (Student) session.getAttribute("student");
		student.setStatus(true);
		Stream stream = student.getStream();
		if (student.getQuota().equals("Normal")) {
			stream.setNseat(stream.getNseat() - 1);
		} else {
			stream.setMseat(stream.getMseat() - 1);
		}
		student.setStream(stream);
		studentDao.save(student);
		view.addObject("success", "Successfully Enrolled Pay fee and Wait for confirmation");
		return view;
	}

	public ModelAndView reject(HttpSession session) {
		ModelAndView view = new ModelAndView("StudentHome");
		Student student = (Student) session.getAttribute("student");
		student.setCourse(null);
		student.setStream(null);
		student.setQuota(null);
		view.addObject("fail", "Successfully Rejected");
		return view;
	}

	public ModelAndView fetchAllAcceptedStudent() {
		ModelAndView view = new ModelAndView();
		List<Student> list = studentDao.fetchAllApprovedStudents();
		if (list.isEmpty()) {
			view.setViewName("AdminHome");
			view.addObject("fail", "Currently no student have enrolled");
		} else {
			view.setViewName("ApproveStudent");
			view.addObject("students", list);
		}

		return view;
	}

	public ModelAndView approveStudent(int id) {
		ModelAndView view = new ModelAndView("AdminHome");
		view.addObject("success", "Approved Success");
		Student student = studentDao.fetch(id);
		student.setDoj(Date.valueOf(LocalDate.now()));
		studentDao.save(student);
		return view;
	}
}
