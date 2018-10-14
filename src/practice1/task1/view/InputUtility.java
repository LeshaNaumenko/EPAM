package practice1.task1.view;

import java.util.Scanner;

public class InputUtility {

    private static Scanner scanner = new Scanner(System.in);

    public static int inputIntValueWithScanner(View view) {


        int number;
        do {
            view.printMessage(View.INPUT_INT_DATA);
            while (!scanner.hasNextInt()) {
                view.printMessage(View.WRONG_INPUT_INT_DATA + "\n" + View.INPUT_INT_DATA);
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        return number;
    }

    public static int getValueOfConditionWithScanner(View view) {

        view.printMessage(View.CONDITION);
        while (true) {
            if (scanner.hasNextInt()) {
                int valueInt = scanner.nextInt();

                switch (valueInt){
                    case 0:return 0;
                    case 2:return 2;
                    case 8:return 8;
                    case 16:return 16;
                    default: view.printMessage(View.WRONG_INPUT_INT_DATA + "\n" + View.CONDITION);
                }

            } else {
                view.printMessage(View.WRONG_INPUT_INT_DATA + "\n" + View.CONDITION);
                scanner.next();
            }
        }
    }
}
