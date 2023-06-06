package com.tarun.collegesoft.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Component
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long mobile;
	private int age;
	private Date dob;
	private boolean status;
	private String gender;
	private Date doj;
	private String password;
	private double sslc;
	private double puc;
	private String quota;
	 
	
	@ManyToOne
	private Course course;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Stream stream;



	// public int getId() {
	// 	return id;
	// }

	// public void setId(int id) {
	// 	this.id = id;
	// }

	// public String getName() {
	// 	return name;
	// }

	// public void setName(String name) {
	// 	this.name = name;
	// }

	// public String getEmail() {
	// 	return email;
	// }

	// public void setEmail(String email) {
	// 	this.email = email;
	// }

	// public long getMobile() {
	// 	return mobile;
	// }

	// public void setMobile(long mobile) {
	// 	this.mobile = mobile;
	// }

	// public int getAge() {
	// 	return age;
	// }

	// public void setAge(int age) {
	// 	this.age = age;
	// }

	// public Date getDob() {
	// 	return dob;
	// }

	// public void setDob(Date dob) {
	// 	this.dob = dob;
	// }

	// public boolean isStatus() {
	// 	return status;
	// }

	// public void setStatus(boolean status) {
	// 	this.status = status;
	// }

	// public String getGender() {
	// 	return gender;
	// }

	// public void setGender(String gender) {
	// 	this.gender = gender;
	// }

	// public Date getDoj() {
	// 	return doj;
	// }

	// public void setDoj(Date doj) {
	// 	this.doj = doj;
	// }

	// public String getPassword() {
	// 	return password;
	// }

	// public void setPassword(String password) {
	// 	this.password = password;
	// }

	// public Cources getCourse() {
	// 	return course;
	// }

	// public void setCourse(Cources course) {
	// 	this.course = course;
	// }

	// public Streamdto getStream() {
	// 	return stream;
	// }

	// public void setStream(Streamdto stream) {
	// 	this.stream = stream;
	// }

	// @Override
	// public String toString() {
	// 	return "StudentDto [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", age=" + age
	// 			+ ", dob=" + dob + ", status=" + status + ", gender=" + gender + ", doj=" + doj + ", password="
	// 			+ password + ", course=" + course + ", stream=" + stream + "]";
	// }
	
	

}
