package com.in28minutes.rest.webservices.resfulwebservices.user;

import com.in28minutes.rest.webservices.resfulwebservices.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
//        repository.save("Opel", LocalDate.now().minusYears(5));
    }
}

