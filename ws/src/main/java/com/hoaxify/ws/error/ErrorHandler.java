package com.hoaxify.ws.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class ErrorHandler implements ErrorController {
	
	@Autowired
	private ErrorAttributes errorAttributes;
	
	@RequestMapping("/error")
	ApiError handleError(WebRequest webRequest) {
		Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(Include.MESSAGE, Include.BINDING_ERRORS));
		String message = (String)attributes.get("message");
		String path = (String) attributes.get("path");
		int status = (Integer) attributes.get("status");
		ApiError error = new ApiError(status, message, path);
		if(attributes.containsKey("errors")) {
			@SuppressWarnings("unchecked")
			List<FieldError> fieldErrors = (List<FieldError>)attributes.get("errors");
			Map<String, String> validationErrors = new HashMap<>();
			for(FieldError fieldError: fieldErrors) {
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			error.setValidationErrors(validationErrors);
		}
		return error; 
	}
	

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
