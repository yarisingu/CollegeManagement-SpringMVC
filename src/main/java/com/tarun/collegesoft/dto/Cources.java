package com.tarun.collegesoft.dto;

import org.springframework.stereotype.Component;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Cources {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String cname;
	double fee;
	int duration;
	
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
		return "Cources [id=" + id + ", cname=" + cname + ", fee=" + fee + ", duration=" + duration + "]";
	}
	
	
	
}
