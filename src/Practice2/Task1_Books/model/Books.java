package Practice2.Task1_Books.model;


import Practice2.Task1_Books.model.comparator.BookPublisherComparator;
import Practice2.Task1_Books.model.entity.Book;

import java.util.Arrays;

public class Books {
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
            if (book.getYear() < year) {
                temp[counter++] = book;
            }
        }
        return Arrays.copyOf(temp, counter);
    }

    public Book[] getOrderedBooksByPublisher() {
        Book[] temp = Arrays.copyOf(books, books.length);
        Arrays.sort(temp, new BookPublisherComparator());
        return temp;
    }

/*    public <T> Book[] getSomething(T[] array, T items){
        Book[] temp
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals())
        }
    }*/
}
