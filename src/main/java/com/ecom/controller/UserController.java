package com.ecom.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.AuthUser;
import com.ecom.model.UserModel;
import com.ecom.response.SuccessResponse;
import com.ecom.service.UserService;
import com.ecom.util.JWTUtil;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/home")
	public String home() {
		return "welcome to application world";
	}
//	@GetMapping("/home")
//	public String myHome() {
//		return "welcome to application world";
//	}
//	
	@PostMapping("/auth")
	public ResponseEntity<?> authUser(@RequestBody AuthUser authUser) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authUser.getUserName(), authUser.getPassword())
		);
		}catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(false,"", "invalid username/password"));
		}
		String key= jwtUtil.generateToken(authUser.getUserName());
		
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(true,key, "Login Success"));
	}
	
	@PostMapping("/auth/registeation")
	public ResponseEntity<?> registeUser(@RequestBody UserModel user){
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserModel user1=userService.saveUser(user);
		
		if(user1!=null)
			return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(true, user1.getName(), "success"));
		else
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new SuccessResponse(false,user.getName(), "failed"));
		
	}

}
