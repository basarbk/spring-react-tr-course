package com.hoaxify.ws.hoax;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.hoaxify.ws.user.User;

import lombok.Data;

@Data
@Entity
public class Hoax {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min=1, max=1000)
	@Column(length = 1000)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@ManyToOne
	private User user;
}
