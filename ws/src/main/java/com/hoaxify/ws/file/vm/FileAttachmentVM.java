package com.hoaxify.ws.file.vm;

import com.hoaxify.ws.file.FileAttachment;

import lombok.Data;

@Data
public class FileAttachmentVM {
	
	private String name;
	
	public FileAttachmentVM(FileAttachment fileAttachment) {
		this.setName(fileAttachment.getName());
	}

}
