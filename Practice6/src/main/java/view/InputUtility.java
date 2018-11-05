package view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtility {

    private Scanner scanner;
    private BooksView booksView;

    public void setView(BooksView booksView) {
        this.booksView = booksView;
    }

    public String getPath() {
        scanner = new Scanner(System.in);
        booksView.printMessage(ConstantMessage.ENTER_A_PATH);
        Pattern compile = Pattern.compile("((\\w{1}:\\\\(([A-z]|[0-9]|\\s)+)\\\\\\w+\\.\\w+))|(\\w{1}:\\\\(\\w+\\.\\w+))");
        String temp;
        while (!(temp = scanner.nextLine()).equals("n")) {
            Matcher m = compile.matcher(temp);
            if (m.find()) {
                break;
            }
            booksView.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA);
        }
        return temp;
    }

    public static void main(String[] args) {
        InputUtility inputUtility = new InputUtility();
        inputUtility.setView(new BooksView());
        inputUtility.getPath();
    }

    public String getLine() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getPosNumber() {
        scanner = new Scanner(System.in);
        int input;
        while (true) {
            booksView.printMessage(ConstantMessage.POSITIVE);
            if (!scanner.hasNextInt()) {
                booksView.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA);
                scanner.next();
                continue;
            }
            input = scanner.nextInt();
            if (input < 0) {
                booksView.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA);
                continue;
            }
            return input;
        }
    }
}
