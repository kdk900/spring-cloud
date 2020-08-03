package com.spring.cloud.zuulservice.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("kalyan".equals(username)) {//password is also kalyan encrypted using  online BCrypt generator. -> https://www.javainuse.com/onlineBcrypt
			return new User("kalyan", "$2a$10$br8op1IX0ujrqDc5wmhRWOXONmCSo8zVYWtxJPLfll6WwPz/lgM2q",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}