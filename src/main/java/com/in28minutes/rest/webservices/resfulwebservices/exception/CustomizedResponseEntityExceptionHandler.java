package com.in28minutes.rest.webservices.resfulwebservices.exception;

import com.in28minutes.rest.webservices.resfulwebservices.user.UserNotFoundExceltion;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice //Make this class picked up by spring framework
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //Overriding the method "handleException"from "ResponseEntityExceptionHandler" class
    @ExceptionHandler(Exception.class) //Override for all exception
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception
    {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundExceltion.class) //Only for 404 error
    public final ResponseEntity<ErrorDetails> handleUserNotFound(Exception ex, WebRequest request) throws Exception
    {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

    	ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getFieldError().getDefaultMessage(), request.getDescription(false));

        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);

	}
}
