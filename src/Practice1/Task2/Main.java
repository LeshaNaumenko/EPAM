package Practice1.Task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(getIdeal(input));
    }

    private static String getIdeal(int input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < input; j++) {
            if (ideal(j)){
                stringBuilder.append(j+" ");
            }
        }
        return stringBuilder.toString();
    }

    public static boolean ideal(int value){
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        for (int i = 2; i < value; i++){
            if (value % i == 0)numbers.add(i);
        }
        int sum = 0;
        for (int i : numbers)sum += i;
        if (sum == value)return true;
        else             return false;
    }

}
