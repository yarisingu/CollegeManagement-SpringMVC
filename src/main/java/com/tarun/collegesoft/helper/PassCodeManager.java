package com.tarun.collegesoft.helper;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Component
@Data
public class PassCodeManager {
    
    // Admin acess

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String password;
    String email;
    int otp;
    
}
