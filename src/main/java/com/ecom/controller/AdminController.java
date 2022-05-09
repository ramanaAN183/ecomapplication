package com.ecom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.response.SuccessResponse;

@RestController
@RequestMapping("/a")
public class AdminController {
	
	@GetMapping("/adminhome")
	public ResponseEntity<?> adminHome(){
		
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(true,"", "success"));
	}
	

}
