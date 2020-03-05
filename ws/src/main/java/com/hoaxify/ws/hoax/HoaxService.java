package com.hoaxify.ws.hoax;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public long getNewHoaxesCountOfUser(long id, String username) {
		User inDB = userService.getByUsername(username);
		return hoaxRepository.countByIdGreaterThanAndUser(id, inDB);
	}

	public List<Hoax> getNewHoaxes(long id, Sort sort) {
		return hoaxRepository.findByIdGreaterThan(id, sort);
	}

	public List<Hoax> getNewHoaxesOfUser(long id, String username, Sort sort) {
		User inDB = userService.getByUsername(username);
		return hoaxRepository.findByIdGreaterThanAndUser(id, inDB, sort);
	}
	
	

}
