package com.hoaxify.ws.hoax.vm;

import com.hoaxify.ws.hoax.Hoax;
import com.hoaxify.ws.user.vm.UserVM;

import lombok.Data;

@Data
public class HoaxVM {
	
	private long id;
	
	private String content;
	
	private long timestamp;

	private UserVM user;
	
	public HoaxVM(Hoax hoax) {
		this.setId(hoax.getId());
		this.setContent(hoax.getContent());
		this.setTimestamp(hoax.getTimestamp().getTime());
		this.setUser(new UserVM(hoax.getUser()));
	}
}
