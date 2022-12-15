import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    static public int[] getArrayOfRandomNumbers(int size, int lowBound, int highBound)
            throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (lowBound >= highBound) {
            throw new IllegalArgumentException("bound must be greater than origin");
        } else if (highBound < 0) {
            throw new IllegalArgumentException("bound must be positive");
        }

        int[] array = new Random().ints(size, lowBound, highBound).toArray();
        return array;
    }

    static public int[] getArrayOfRandomNumbers(int size) {
        return getArrayOfRandomNumbers(size, 0, 10);
    }

    static public double getEvenNumbersAverage(int[] array) {
        Double average = Arrays.stream(array).filter(o -> o % 2 == 0).average().getAsDouble();
        return average;
    }

    static public void task1() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        List<String> result = myList.stream().filter(e -> e.startsWith("c")).map(name -> name.toUpperCase()).sorted().collect(Collectors.toList());

        System.out.print("[");
        for (String str : result) {
            System.out.print(str + " ");
        }
        System.out.println("]");
    }

    static public void task2() {
        int[] array = getArrayOfRandomNumbers(10);

        System.out.print("[");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("]");

        System.out.print("Average: ");
        System.out.print(getEvenNumbersAverage(array));
    }

    static public void task3() {
        String str = "sjdhgfsjkavchjwagehf";

        str.chars().mapToObj(e -> (e > 'h' && e < 't') ? Character.toUpperCase((char) e) : (char) e).forEach(t -> System.out.print(t + " "));
    }

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
    }
}