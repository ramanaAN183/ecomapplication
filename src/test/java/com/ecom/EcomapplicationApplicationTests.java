package com.ecom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.ecom.controller.UserController;
import com.ecom.model.AuthUser;

@SpringBootTest
class EcomapplicationApplicationTests {
	
	@Autowired
	private UserController userControl; 
	
	AuthUser authUser=new AuthUser();
	@Test
	void myTest() throws Exception {
		
		
		authUser.setUserName("Ramana");
		authUser.setPassword("ram");
		ResponseEntity<?> rs=userControl.authUser(authUser);
		assertEquals(200, rs.getStatusCodeValue());
	
		
	}
	@Test
	void myTestwithoutPassword() throws Exception {
		
		authUser.setUserName("Ramana");
		
		ResponseEntity<?> rs=userControl.authUser(authUser);
		assertEquals(200, rs.getStatusCodeValue());
	
		
	}

	
}
