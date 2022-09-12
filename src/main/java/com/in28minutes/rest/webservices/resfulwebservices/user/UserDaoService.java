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
    private static int userCount = 0;

    static
    {
        users.add(new User(++userCount, "Opel", LocalDate.now().minusYears(35)));
        users.add(new User(++userCount, "Shamma", LocalDate.now().minusYears(35)));
        users.add(new User(++userCount, "Aayid", LocalDate.now().minusYears(3)));
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
        // return users.stream().filter(predicate).findFirst().get(); //Throws exception if the user is not found
        return users.stream().filter(predicate).findFirst().orElse(null); //Null returns if user is not found
    }

    public User saveUser(User user)
    {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id)
    {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }
}
