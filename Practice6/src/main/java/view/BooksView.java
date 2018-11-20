package view;


import model.entity.Book;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class BooksView {
    static Logger logger = Logger.getLogger(BooksView.class);

    public void printBooks(String message, Book[] books) {
        System.out.println(message);
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
        logger.info("print books: "+ Arrays.toString(books));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
