package com.hoaxify.ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.hoaxify.ws.hoax.HoaxService;
import com.hoaxify.ws.hoax.vm.HoaxSubmitVM;
import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserService;

@SpringBootApplication
public class WsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}
	
	@Bean
	@Profile("dev")
	CommandLineRunner createInitialUsers(UserService userService, HoaxService hoaxService) {
		return (args) -> {
			try {
				userService.getByUsername("user1");				
			} catch (Exception e) {				
				for(int i = 1; i<=25;i++) {				
					User user = new User();
					user.setUsername("user"+i);
					user.setDisplayName("display"+i);
					user.setPassword("P4ssword");
					userService.save(user);
					for(int j = 1;j<=20;j++) {
						HoaxSubmitVM hoax = new HoaxSubmitVM();
						hoax.setContent("hoax (" +j + ") from user ("+i+")");
						hoaxService.save(hoax, user);
					}
				}
			}
		};
	}

}
