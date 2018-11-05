package model;

import model.entity.Book;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Books implements Serializable {
    private Book[] books;

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getByAuthor(String author) {
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().equals(author)) {
                temp[counter++] = books[i];
            }
        }
        return Arrays.copyOf(temp, counter);
    }

    public Book[] getByPublisher(String publisher) {
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                temp[counter++] = book;
            }
        }
        return Arrays.copyOf(temp, counter);
    }

    public Book[] getBooksLater(int year) {
        Book[] temp = new Book[books.length];
        int counter = 0;
        for (Book book : books) {
            if (book.getYear() > year) {
                temp[counter++] = book;
            }
        }
        return Arrays.copyOf(temp, counter);
    }

    public Book[] sort(Comparator<Book> comparator) {
        Book[] temp = Arrays.copyOf(books, books.length);
        Arrays.sort(temp, comparator);
        return temp;
    }
}
