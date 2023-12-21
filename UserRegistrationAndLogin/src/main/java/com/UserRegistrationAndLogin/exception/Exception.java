package com.UserRegistrationAndLogin.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {

	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus
	
	public Map<String, String> handleMethodArgumentException(MethodArgumentNotValidException exception){
		Map<String, String> errorMap=new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error->
		{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
		
}
}