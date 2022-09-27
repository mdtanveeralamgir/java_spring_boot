package functionalProgramming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayWithOptional {

    public static void main(String[] args)
    {
        List<String> fruits = List.of("Apple", "Mango", "Orange", "banana");

        //list of fruits starts with b
        Predicate<? super String> predicate = fruit -> fruit.startsWith("c");
        //This might return a fruit or null
        //Thats why the return value is stored in Optional class with generic String
        //To deal with null pointer exception
        Optional<String> optional = fruits.stream().filter(predicate).findFirst();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());


        //Creating value with option
        Optional<String> fruit = Optional.of("Kiwi");
        Optional<String> empty = Optional.empty(); //This will return empty value

    }
}
