package project1_mobile_service.view;

import java.util.Scanner;

/**
 * {@code InputUtility} class provides methods to validate input.
 *
 * @author Alex Naumenko
 * @see Scanner
 * @version 1.0
 */

public class InputUtility {
    /**
     * ViewTariff instance.
     */
    private ViewTariff viewTariff;

    /**
     * Parameter viewTariff to set
     * @param viewTariff
     */

    public void setViewTariff(ViewTariff viewTariff) {
        this.viewTariff = viewTariff;
    }

    /**
     * Scanner instance
     */
    private static Scanner scanner;

    /**
     * Returns the entered string
     * @return string
     */
    public String getLine(){
        scanner = new Scanner(System.in);
        viewTariff.printMessageWithoutLn(ConstantsMessage.ENTER_NAME_OF_TARIFF);
        String string = scanner.nextLine();
        return string;
    }

    /**
     * Returns a positive number
     * @param spaceForFindMenu
     * @return
     */
    public int inputNumber(String spaceForFindMenu){
        scanner = new Scanner(System.in);
        int input;
        while (true) {
            viewTariff.printMessageWithoutLn(spaceForFindMenu+ConstantsMessage.POSITIVE);
            if (!scanner.hasNextInt()) {
                viewTariff.printMessage(ConstantsMessage.WRONG_INPUT_INT_DATA);
                scanner.next();
                continue;
            }
            input = scanner.nextInt();
            if (input < 0) {
                viewTariff.printMessage(ConstantsMessage.WRONG_INPUT_INT_DATA);
                continue;
            }
            return input;
        }
    }
}