package project1_mobile_service.view;

import java.util.Scanner;

public class InputUtility {

    private ViewTariff viewTariff;

    public void setViewTariff(ViewTariff viewTariff) {
        this.viewTariff = viewTariff;
    }

    private static Scanner scanner;

    public String getLine(){
        scanner = new Scanner(System.in);
        viewTariff.printMessageWithoutLn("Enter name of tariff>>");
        String s = scanner.nextLine();
        return s;
    }
    public int inputNumber(String spaceForFindMenu){
        scanner = new Scanner(System.in);
        int input;
        while (true) {
            viewTariff.printMessageWithoutLn(spaceForFindMenu+"Enter a positive number >>");
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
