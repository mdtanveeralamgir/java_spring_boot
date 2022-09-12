package com.in28minutes.rest.webservices.resfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) //Returns 404 error code
public class UserNotFoundExceltion extends RuntimeException {
    public UserNotFoundExceltion(String message)
    {
        super(message);
    }
}
