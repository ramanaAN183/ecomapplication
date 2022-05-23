package com.ecom.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ecom.model.UserModel;
import com.ecom.repositeory.UserRepositeory;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepositeory userRepositeory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<SimpleGrantedAuthority> role=null;
		
	UserModel um=userRepositeory.userLogin(username);
		
	if(um.getName()!=null) {
	
		role=Arrays.asList(new SimpleGrantedAuthority(um.getRole()));
	return  new User(um.getName(),um.getPassword(),role);
	}
	else
		return  (UserDetails) new UsernameNotFoundException("");
	}
	
}
