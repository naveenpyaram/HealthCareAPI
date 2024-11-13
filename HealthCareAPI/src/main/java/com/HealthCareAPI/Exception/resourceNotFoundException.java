package com.HealthCareAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class resourceNotFoundException extends Exception{
	public resourceNotFoundException(String message) {
		super(message);
	}

}