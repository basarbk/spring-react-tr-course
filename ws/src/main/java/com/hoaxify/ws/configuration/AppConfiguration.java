package com.hoaxify.ws.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "hoaxify")
public class AppConfiguration {

	private String uploadPath;
	
	private String profileStorage = "profile";
	
	private String attachmentStorage = "attachments";
	
	public String getProfileStoragePath() {
		return uploadPath + "/" + profileStorage;
	}
	
	public String getAttachmentStoragePath() {
		return uploadPath + "/" + attachmentStorage;
	}
}
