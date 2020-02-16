package com.hoaxify.ws.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void save(User user) {
		userRepository.save(user);
	}

}
