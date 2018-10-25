package view;


import model.entity.Book;

public class BooksView {

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
