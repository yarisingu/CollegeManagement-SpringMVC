package com.tarun.collegesoft.helper;

import org.springframework.stereotype.Component;

@Component
public class Login {
	
	String email;
	String passcode;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	
	@Override
	public String toString() {
		return "Login [email=" + email + ", passcode=" + passcode + "]";
	}
	

	
	
}
