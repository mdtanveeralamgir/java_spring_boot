package functionalProgramming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args)
    {

        printAllNumbersInListFunctional(List.of(1,3,12,43,23,12,54));
    }

    //Traditional approach
    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //First convert the list of numbers into stream
        //Stream will separate each number for the list
        //Then we can do a "Method reference" on each of that number
        numbers.stream().forEach(FP01Functional::print); //Method reference, defining the behavior
    }

    private static void print(int number)
    {
        System.out.println(number);
    }
}
