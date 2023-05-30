package com.tarun.collegesoft.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Component
@Data
public class Cources {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String cname;
	double fee;
	int duration;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Streamdto> streams;
	
	
	@OneToMany
	private List<StudentDto> students;
	
	
	
	public List<StudentDto> getStudents() {
		return students;
	}
	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}
	public List<Streamdto> getStreams() {
		return streams;
	}
	public void setStreams(List<Streamdto> streams) {
		this.streams = streams;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Cources [id=" + id + ", cname=" + cname + ", fee=" + fee + ", duration=" + duration + ", streams="
				+ streams + ", students=" + students + "]";
	}
	
	
	
	
	
	
	
	
}
