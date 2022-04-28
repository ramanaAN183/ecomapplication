package com.ecom.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecom.model.UserModel;
import com.ecom.repositeory.UserRepositeory;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepositeory userRepositeory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//System.out.println("--1---");
	UserModel um=userRepositeory.userLogin(username);
	if(um.getName()!=null) {
	//System.out.println(um.getId()+"--"+um.getName()+"--"+um.getPassword()+"--"+um.getRole()+"--"+um.getIsActive()+"--");
	return  new User(um.getName(),um.getPassword(),new ArrayList<>());
	}
	else
		return  (UserDetails) new UsernameNotFoundException("");
			
	}

}
