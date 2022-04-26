package com.ecom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecom.controller.UserController;

@SpringBootTest
class EcomapplicationApplicationTests {
	
	@Autowired
	private UserController userControl; 
	
	@Test
	void contextLoads() {
	}

	
}
