package com.hoaxify.ws.file;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoaxify.ws.user.User;

public interface FileAttachmentRepository extends JpaRepository<FileAttachment, Long>{
	
	List<FileAttachment> findByDateBeforeAndHoaxIsNull(Date date);
	
	List<FileAttachment> findByHoaxUser(User user);

}
