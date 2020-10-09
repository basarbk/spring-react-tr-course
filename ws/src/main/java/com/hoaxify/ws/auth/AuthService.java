package com.hoaxify.ws.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserService;
import com.hoaxify.ws.user.vm.UserVM;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {
	
	UserService userService;
	
	PasswordEncoder passwordEncoder;
	
	public AuthService(UserService userService, PasswordEncoder passwordEncoder) {
		super();
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	public AuthResponse authenticate(Credentials credentials) {
		User inDB = userService.getByUsername(credentials.getUsername());
		boolean matches = passwordEncoder.matches(credentials.getPassword(), inDB.getPassword());
		if(matches) {
			UserVM userVM = new UserVM(inDB);
			String token = Jwts.builder().setSubject(""+inDB.getId()).signWith(SignatureAlgorithm.HS512, "my-app-secret").compact();
			AuthResponse response = new AuthResponse();
			response.setUser(userVM);
			response.setToken(token);
			return response;
		}
		return null;
	}

}
