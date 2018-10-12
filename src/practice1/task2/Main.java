package practice1.task2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        for (String arg : args) {
            System.out.println("arg = " + arg);
        }

        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            System.out.println("Enter a positive number");
            System.out.print(">>");
            if (!scanner.hasNextInt()) {
                System.out.println("**Repeat please**");
                scanner.next();
                continue;
            }
            input = scanner.nextInt();

            if (input <= 0) {
                System.out.println("**Repeat please**");
                continue;
            }
            break;
        }
        System.out.println(getPerfect(input));
    }

    private static String getPerfect(int input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < input; j++) {
            if (perfect(j)) {
                stringBuilder.append(j + " ");
            }
        }
        if (stringBuilder.length() == 0)return "No perfect numbers";
        return stringBuilder.toString();
    }

    public static boolean perfect(int value) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 2; i < value; i++) {
            if (value % i == 0) numbers.add(i);
        }
        int sum = 1;
        for (int i : numbers) sum += i;
        if (sum == value && sum != 1) return true;
        else return false;
    }




}
