package com.hoaxify.ws.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserRepository;
import com.hoaxify.ws.user.vm.UserVM;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {
	
	UserRepository userRepository;
	
	PasswordEncoder passwordEncoder;
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public AuthResponse authenticate(Credentials credentials) {
		User inDB = userRepository.findByUsername(credentials.getUsername());
		if(inDB == null) {
			throw new AuthException();			
		}
		boolean matches = passwordEncoder.matches(credentials.getPassword(), inDB.getPassword());
		if(!matches) {
			throw new AuthException();
		}
		UserVM userVM = new UserVM(inDB);
		String token = Jwts.builder().setSubject(""+inDB.getId()).signWith(SignatureAlgorithm.HS512, "my-app-secret").compact();
		AuthResponse response = new AuthResponse();
		response.setUser(userVM);
		response.setToken(token);
		return response;
	}

}
