package com.tarun.collegesoft.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	@Column(columnDefinition = "MEDIUMBLOB")
	byte[] picture;

	@ManyToOne
	private Course course;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Stream stream;
}