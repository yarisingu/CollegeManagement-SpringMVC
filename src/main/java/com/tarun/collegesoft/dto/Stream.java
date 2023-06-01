package com.tarun.collegesoft.dto;



import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Component
@Data
public class Stream {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	double fee;
	int seat;
	
	@OneToMany
	private List<Student> students;
	

	
	// public List<StudentDto> getStudents() {
	// 	return students;
	// }

	// public void setStudents(List<StudentDto> students) {
	// 	this.students = students;
	// }

	// public int getSeat() {
	// 	return seat;
	// }

	// public void setSeat(int seat) {
	// 	this.seat = seat;
	// }

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

	// public double getFee() {
	// 	return fee;
	// }

	// public void setFee(double fee) {
	// 	this.fee = fee;
	// }

	// @Override
	// public String toString() {
	// 	return "Streamdto [id=" + id + ", name=" + name + ", fee=" + fee + ", seat=" + seat + ", students=" + students
	// 			+ "]";
	// }


	
	
	
	

}
