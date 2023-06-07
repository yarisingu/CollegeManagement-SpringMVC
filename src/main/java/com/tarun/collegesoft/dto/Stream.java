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
	private int id;
	private String name;
	private double fee;
	private int seat;
	private int mseat;
	private int nseat;
	
	
	@OneToMany
	private List<Student> students;


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


	public double getFee() {
		return fee;
	}


	public void setFee(double fee) {
		this.fee = fee;
	}


	public int getSeat() {
		return seat;
	}


	public void setSeat(int seat) {
		this.seat = seat;
	}


	public int getMseat() {
		return mseat;
	}


	public void setMseat(int mseat) {
		this.mseat = mseat;
	}


	public int getNseat() {
		return nseat;
	}


	public void setNseat(int nseat) {
		this.nseat = nseat;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "Stream [id=" + id + ", name=" + name + ", fee=" + fee + ", seat=" + seat + ", mseat=" + mseat
				+ ", nseat=" + nseat + ", students=" + students + "]";
	}
	
	

}
