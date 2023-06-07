package com.tarun.collegesoft.dto;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
	private String usn;
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

	@Lob
	byte[] picture;
	 
	
	@ManyToOne
	private Course course;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Stream stream;
	
	

	public String getUsn() {
		return usn;
	}

	public void setUsn(String usn) {
		this.usn = usn;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSslc() {
		return sslc;
	}

	public void setSslc(double sslc) {
		this.sslc = sslc;
	}

	public double getPuc() {
		return puc;
	}

	public void setPuc(double puc) {
		this.puc = puc;
	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Stream getStream() {
		return stream;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", usn=" + usn + ", email=" + email + ", mobile=" + mobile
				+ ", age=" + age + ", dob=" + dob + ", status=" + status + ", gender=" + gender + ", doj=" + doj
				+ ", password=" + password + ", sslc=" + sslc + ", puc=" + puc + ", quota=" + quota + ", picture="
				+ Arrays.toString(picture) + ", course=" + course + ", stream=" + stream + "]";
	}




}