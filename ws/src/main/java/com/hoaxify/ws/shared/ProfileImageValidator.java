package com.hoaxify.ws.shared;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.hoaxify.ws.file.FileService;

public class ProfileImageValidator implements ConstraintValidator<ProfileImage, String>{
	
	@Autowired
	FileService fileService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.isEmpty()) {
			return true;
		}
		String fileType = fileService.detectType(value);
		if(fileType.equalsIgnoreCase("image/jpeg") || fileType.equalsIgnoreCase("image/png")) {
			return true;
		}
		
		return false;
	}

}
