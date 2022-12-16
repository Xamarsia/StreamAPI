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
        if (array == null) {
            return 0;
        }
        Double average = Arrays.stream(array)
                .filter(o -> o % 2 == 0)
                .average().getAsDouble();
        return average;
    }

    static public void task1() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        List<String> result = myList.stream()
                .filter(e -> e.startsWith("c"))
                .map(name -> name.toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        for (String str : result) {
            System.out.print(str + " ");
        }
    }

    static public void task2() {
        int[] array = getArrayOfRandomNumbers(10);

        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.print("Average: ");
        System.out.print(getEvenNumbersAverage(array));
    }

    static public void task3() {
        String str = "sjdhgfsjkavchjwagehf";

        List<Character> myList = str.chars()
                .mapToObj(e -> (e > 'h' && e < 't')
                        ? Character.toUpperCase((char) e)
                        : (char) e)
                .collect(Collectors.toList());


        for (char i : myList) {
            System.out.print(i + " ");
        }

    }

    static List<User> getListFilledWithUsers() {
        List<User> list = new ArrayList<>();
        String name = "Tom";
        int age = 10;
        String email = "tomsEmail";

        for (int i = 0; i < 15; i++) {
            User user = new User(name + i, age + i, email + i + "@gmail.com");
            list.add(user);
        }
        return list;
    }

    static public List<UserDto> getUsersWhichOlderThan17(List<User> usersList) {
        List<UserDto> usersWhichOlderThan17 = usersList
                .stream()
                .filter(c -> c.getAge() > 17)
                .map(user -> UserMapper.mapToDto(user))
                .collect(Collectors.toList());
        return usersWhichOlderThan17;
    }

    static public void task5() {
        List<User> usersList = getListFilledWithUsers();
        List<UserDto> filteredUsers = getUsersWhichOlderThan17(usersList);

        for (UserDto userDto : filteredUsers) {
            System.out.print("Name: " + userDto.getName() + " ");
            System.out.print("Age: " + userDto.getAge() + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4 done in another project
//        task5();
    }
}