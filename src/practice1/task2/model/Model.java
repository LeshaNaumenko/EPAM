package practice1.task2.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    StringBuilder perfectNumber = new StringBuilder();

    public String getPerfectNumber() {
        return perfectNumber.toString();
    }


    public String calculatePerfect(int input) {
        for (int j = 0; j < input; j++) {
            if (perfect(j)) {
                perfectNumber.append(j + " ");
            }
        }
        return perfectNumber.toString();
    }

    private boolean perfect(int value) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 2; i < value; i++) {
            if (value % i == 0) numbers.add(i);
        }
        int sum = 1;
        for (int i : numbers) sum += i;
        if (sum == value && sum != 1) return true;
        else return false;
    }

}
