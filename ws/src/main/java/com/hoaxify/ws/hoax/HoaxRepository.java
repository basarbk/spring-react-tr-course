package com.hoaxify.ws.hoax;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hoaxify.ws.user.User;

public interface HoaxRepository extends JpaRepository<Hoax, Long>{
	
	Page<Hoax> findByUser(User user, Pageable page);

}
