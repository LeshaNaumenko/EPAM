package view;

import java.util.Scanner;

public class InputUtility {

    private Scanner scanner;
    private BooksView booksView;

    public void setView(BooksView booksView) {
        this.booksView = booksView;
    }

    public String getLine(){
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
