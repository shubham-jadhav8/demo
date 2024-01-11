package com.example.demo.exeception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public void methodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
      ex.getFieldErrors();
}
	
}
