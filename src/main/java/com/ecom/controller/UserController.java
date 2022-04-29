package com.ecom.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.AuthUser;
import com.ecom.model.UserModel;
import com.ecom.service.UserService;
import com.ecom.util.JWTUtil;

@RestController
//@RequestMapping("/v1")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/home")
	public String home() {
		return "welcome to application";
	}
	
	@PostMapping("/auth")
	public String authUser(@RequestBody AuthUser authUser) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authUser.getUserName(), authUser.getPassword())
		);
		}catch (Exception e) {
			throw new Exception("invalid username/password");
		}
		
		return jwtUtil.generateToken(authUser.getUserName());
	}
	
	@PostMapping("/user-registeation")
	public ResponseEntity<?> registeUser(@RequestBody UserModel user){
		
		UserModel user1=userService.saveUser(user);
		
		if(user1!=null)
			return null;
		else
		return null;
		
	}

}
