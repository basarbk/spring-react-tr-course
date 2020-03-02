package com.hoaxify.ws.hoax;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HoaxService {
	
	HoaxRepository hoaxRepository;

	public HoaxService(HoaxRepository hoaxRepository) {
		super();
		this.hoaxRepository = hoaxRepository;
	}

	public void save(Hoax hoax) {
		hoax.setTimestamp(new Date());
		hoaxRepository.save(hoax);
	}

	public Page<Hoax> getHoaxes(Pageable page) {
		return hoaxRepository.findAll(page);
	}
	
	

}
