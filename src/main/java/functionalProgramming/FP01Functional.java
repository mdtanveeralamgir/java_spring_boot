package functionalProgramming;

import java.util.List;

public class FP01Functional {

    private static List<Integer> numbers = List.of(1,3,12,43,23,12,54);
    public static void main(String[] args)
    {

//        printAllNumbersInListFunctional(numbers);
        printSquareOfEvenNumbers(numbers);
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
                // .filter(FP01Functional::isEven) // Using a defined method
                .filter(number -> number % 2 == 0) //Lambda expression
                .forEach(System.out::println); //println is a static method inside System.out
    }
    private static void printSquareOfEvenNumbers(List<Integer> numbers) {
        //Adding a filter to print only even numbers
        numbers
                .stream()
                // .filter(FP01Functional::isEven) // Using a defined method
                .filter(number -> number % 2 == 0) //Lambda expression
                .map(number -> Math.pow(number, 2))//Mapping, square the even numbers
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
