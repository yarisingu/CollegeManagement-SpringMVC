package com.tarun.collegesoft.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Component
@Data
public class Faculty {
	
	
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
	private int experience;
	private String subject;
	private String education;

	
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
	// public int getExperience() {
	// 	return experience;
	// }
	// public void setExperience(int experience) {
	// 	this.experience = experience;
	// }
	// public String getSubject() {
	// 	return subject;
	// }
	// public void setSubject(String subject) {
	// 	this.subject = subject;
	// }
	// public String getEducation() {
	// 	return education;
	// }
	// public void setEducation(String education) {
	// 	this.education = education;
	// }
	// @Override
	// public String toString() {
	// 	return "Faculty [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", age=" + age
	// 			+ ", dob=" + dob + ", status=" + status + ", gender=" + gender + ", experience=" + experience
	// 			+ ", subject=" + subject + ", education=" + education + "]";
	// } 
	
	
	
	

}
