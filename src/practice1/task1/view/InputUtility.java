package practice1.task1.view;

import java.util.Scanner;

public class InputUtility {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputIntValueWithScanner(View view) {


        int number;
        do {
            view.printMessage(view.INPUT_INT_DATA);
            while (!scanner.hasNextInt()) {
                view.printMessage(view.WRONG_INPUT_INT_DATA + "\n" + view.INPUT_INT_DATA);
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        return number;
    }

    public static int getValueOfConditionWithScanner(View view) {

        view.printMessage(view.CONDITION);
        while (true) {
            if (scanner.hasNextInt()) {
                int valueInt = scanner.nextInt();
                if (valueInt == 0) {
                    return 0;
                } else {
                    if (valueInt == 2) {
                        return 2;
                    } else {
                        if (valueInt == 8) {
                            return 8;
                        } else {
                            if (valueInt == 16) {
                                return 16;
                            } else {
                                view.printMessage(view.WRONG_INPUT_INT_DATA + "\n" + view.CONDITION);
                            }
                        }
                    }
                }
            } else {
                view.printMessage(view.WRONG_INPUT_INT_DATA + "\n" + view.CONDITION);
                scanner.next();
            }
        }
    }
}
