package controller.service;

import model.Books;
import model.PublisherComparator;
import model.entity.Book;

import java.util.Comparator;

public class Service {
    private Books model;

    public void setModel(Books model) {
        this.model = model;
    }

    public Book[] getBooks() {
        return model.getBooks();
    }

    public void setBooks(Book[] books) {
        model.setBooks(books);
    }

    public Book[] getByAuthor(String author) {
        return model.getByAuthor(author);
    }

    public Book[] getByPublisher(String publisher) {
        return model.getByPublisher(publisher);
    }

    public Book[] getBooksLater(int year) {
        return model.getBooksLater(year);
    }

    public Book[] getOrderedBooksByPublisher() {

        return model.sort(new PublisherComparator());
    }
}
