package com.hoaxify.ws.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/api/1.0/auth")
	AuthResponse handleAuthentication(@RequestBody Credentials credentials) {
		return authService.authenticate(credentials);
	}
	

}
