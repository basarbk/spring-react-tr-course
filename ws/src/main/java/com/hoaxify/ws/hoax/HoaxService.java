package com.hoaxify.ws.hoax;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserService;

@Service
public class HoaxService {
	
	HoaxRepository hoaxRepository;
	
	UserService userService;

	public HoaxService(HoaxRepository hoaxRepository, UserService userService) {
		super();
		this.hoaxRepository = hoaxRepository;
		this.userService = userService;
	}

	public void save(Hoax hoax, User user) {
		hoax.setTimestamp(new Date());
		hoax.setUser(user);
		hoaxRepository.save(hoax);
	}

	public Page<Hoax> getHoaxes(Pageable page) {
		return hoaxRepository.findAll(page);
	}

	public Page<Hoax> getHoaxesOfUser(String username, Pageable page) {
		User inDB = userService.getByUsername(username);
		return hoaxRepository.findByUser(inDB, page);
	}

	public Page<Hoax> getOldHoaxes(long id, Pageable page) {
		return hoaxRepository.findByIdLessThan(id, page);
	}

	public Page<Hoax> getOldHoaxesOfUser(long id, String username, Pageable page) {
		User inDB = userService.getByUsername(username);
		return hoaxRepository.findByIdLessThanAndUser(id, inDB, page);
	}

	public long getNewHoaxesCount(long id) {
		return hoaxRepository.countByIdGreaterThan(id);
	}
	
	

}
