package view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtility {

    ViewWordProcessing viewWordProcessing;
    static Scanner scanner = new Scanner(System.in);

    public void setViewWordProcessing(ViewWordProcessing viewWordProcessing) {
        this.viewWordProcessing = viewWordProcessing;
    }

    public String getPath() {
        scanner = new Scanner(System.in);
        viewWordProcessing.printMessage(ConstantsMessage.ENTER_A_PATH);
        Pattern compile = Pattern.compile("((\\w{1}:\\\\(([A-z]|[0-9]|\\s)+)\\\\\\w+\\.\\w+))|(\\w{1}:\\\\(\\w+\\.\\w+))");
        String temp;
        while (!(temp = scanner.nextLine()).equals("n")) {
            Matcher m = compile.matcher(temp);
            if (m.find()) {
                break;
            }
            viewWordProcessing.printMessage(ConstantsMessage.WRONG_INPUT_INT_DATA);
        }
        return temp;
    }

    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        viewWordProcessing.printMessage(ConstantsMessage.ENTER_TEXT);
        scanner = new Scanner(System.in);
        while (true) {
            String current = scanner.nextLine();
            Pattern stop = Pattern.compile("STOP$");
            Matcher matcher = stop.matcher(current);
            if (matcher.find()) return stringBuilder.toString();
            stringBuilder.append(current + "\n");
        }
    }

    public int getPosNumber(String message) {
        scanner = new Scanner(System.in);
        int input;
        while (true) {
            viewWordProcessing.printMessage(message);
            if (!scanner.hasNextInt()) {
                viewWordProcessing.printMessage(ConstantsMessage.WRONG_INPUT_INT_DATA);
                scanner.next();
                continue;
            }
            input = scanner.nextInt();
            if (input < 0) {
                viewWordProcessing.printMessage(ConstantsMessage.WRONG_INPUT_INT_DATA);
                continue;
            }
            return input;
        }
    }
}
