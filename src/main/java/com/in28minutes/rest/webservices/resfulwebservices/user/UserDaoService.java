package com.in28minutes.rest.webservices.resfulwebservices.user;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component //Spring to manage this

/*
DAO: Data Access Object
Access data from DB
*/
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static
    {
        users.add(new User(1, "Opel", LocalDate.now().minusYears(35)));
        users.add(new User(2, "Shamma", LocalDate.now().minusYears(35)));
        users.add(new User(3, "Aayid", LocalDate.now().minusYears(3)));
    }

    public List<User> findAll()
    {
        return users;
    }
    public User findOne(int id)
    {
//        User result = null;
//        for(User user : users)
//        {
//            if(user.getId() == id)
//            {
//                result = user;
//                break;
//            }
//        }
//
//        return result;
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().get();
    }
}
