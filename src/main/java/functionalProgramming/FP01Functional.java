package functionalProgramming;

import java.util.List;

public class FP01Functional {

    private static List<Integer> numbers = List.of(1,3,12,43,23,12,54);
    public static void main(String[] args)
    {

//        printAllNumbersInListFunctional(numbers);
        printAllEvenNumbersInListFunctional(numbers);
    }

    //Traditional approach
    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //First convert the list of numbers into stream
        //Stream will separate each number for the list
        //Then we can do a "Method reference" on each of that number
        numbers.stream().forEach(FP01Functional::print); //Method reference, defining the behavior
    }
    private static void printAllEvenNumbersInListFunctional(List<Integer> numbers) {
        //Adding a filter to print only even numbers
        numbers
                .stream()
                .filter(FP01Functional::isEven)
                .forEach(System.out::println); //println is a static method inside System.out
    }

    private static boolean isEven(int number)
    {
        return number % 2 == 0;
    }
    private static void print(int number)
    {
        System.out.println(number);
    }
}
