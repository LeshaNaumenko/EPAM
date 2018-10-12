package practice2.task1_books.view;

import practice2.task1_books.model.entity.Book;

public class BooksView {

    public static final String WRONG_INPUT_INT_DATA="Wrong input. Repeat please.";

    public void printBooks(String message, Book[] books) {
        System.out.println(message);
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);


    }
}
