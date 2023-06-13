package com.tarun.collegesoft.helper;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class Login {
	
	private String email;
	private String password;
	private int id;




	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}
	

	

	
	
}
