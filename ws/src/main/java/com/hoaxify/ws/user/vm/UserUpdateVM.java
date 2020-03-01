package com.hoaxify.ws.user.vm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hoaxify.ws.shared.FileType;

import lombok.Data;

@Data
public class UserUpdateVM {
	
	@NotNull
	@Size(min = 4, max=255)
	private String displayName;
	
	@FileType(types= {"jpeg", "png"})
	private String image;

}
