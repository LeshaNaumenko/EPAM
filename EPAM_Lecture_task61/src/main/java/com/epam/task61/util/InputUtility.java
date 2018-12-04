package com.epam.task61.util;

import com.epam.task61.view.BookView;
import java.util.Scanner;

public class InputUtility {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt(BookView view,
                               ResourceManager manager) {
        view.printMessage(
                manager.getMessage("INPUT_INT_DATA"));
        while (!sc.hasNextInt()) {
            view.printMessage(
                    manager.getMessage("WRONG_INPUT_DATA")
                            + manager.getMessage("INPUT_INT_DATA"));
            sc.next();
        }
        return sc.nextInt();
    }

    public static String inputString(BookView view,
                                     ResourceManager manager) {
        while (true) {
            view.printMessage(
                    manager.getMessage("INPUT_STRING_DATA"));
            String text = sc.next();
            if ( Validator.isCorrectString(text)) {
                return text;
            }
            view.printError(
                    manager.getMessage("WRONG_INPUT_DATA"));
        }
    }
}
