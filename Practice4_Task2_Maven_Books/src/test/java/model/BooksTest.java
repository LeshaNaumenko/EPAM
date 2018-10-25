package model;

import model.entity.Book;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BooksTest {

    Book[] later = new Book[]{
                    new Book("Title4", "Maslov", "Piter", 2016, 555, 620.5),
                    new Book("Title7", "Petrov", "Zord", 2018, 276, 155.5),
                    new Book("Title8", "Shevchenko", "Piter", 2013, 456, 100.0)
    };

    Book[] petrov = new Book[]{
            new Book("Title7", "Petrov", "Zord", 2018, 276, 155.5)
    };

    Book[] publisher = new Book[]{
            new Book("Title1", "Shevchenko", "BXV", 2010, 320, 450.0),
            new Book("Title3", "Sokolov", "BXV", 1999, 820, 1050.0),
            new Book("Title6", "Sokolov", "BXV", 2001, 400, 300.0)
    };

    Book[] sort = new Book[]{
            new Book("Title1", "Shevchenko", "BXV", 2010, 320, 450.0),
            new Book("Title3", "Sokolov", "BXV", 1999, 820, 1050.0),
            new Book("Title6", "Sokolov", "BXV", 2001, 400, 300.0),
            new Book("Title4", "Maslov", "Piter", 2016, 555, 620.5),
            new Book("Title5", "Sokolov", "Piter", 1990, 876, 555.5),
            new Book("Title8", "Shevchenko", "Piter", 2013, 456, 100.0),
            new Book("Title2", "Shevchenko", "Word", 2000, 120, 250.0),
            new Book("Title7", "Petrov", "Zord", 2018, 276, 155.5)
    };

    public static Books books;
    @BeforeClass
    public static void setUp() throws Exception {
        books = new Books();
        books.setBooks(new Book[]{
                        new Book("Title1", "Shevchenko", "BXV", 2010, 320, 450.0),
                        new Book("Title2", "Shevchenko", "Word", 2000, 120, 250.0),
                        new Book("Title3", "Sokolov", "BXV", 1999, 820, 1050.0),
                        new Book("Title4", "Maslov", "Piter", 2016, 555, 620.5),
                        new Book("Title7", "Petrov", "Zord", 2018, 276, 155.5),
                        new Book("Title5", "Sokolov", "Piter", 1990, 876, 555.5),
                        new Book("Title6", "Sokolov", "BXV", 2001, 400, 300.0),
                        new Book("Title8", "Shevchenko", "Piter", 2013, 456, 100.0)
                }
        );
    }

    @Test
    public void getByAuthor() {
        assertTrue("Arrays are not equal", java.util.Arrays.equals(petrov, books.getByAuthor("Petrov")));
    }

    @Test
    public void getByPublisher() {
        assertTrue("Arrays are not equal", java.util.Arrays.equals(publisher, books.getByPublisher("BXV")));

    }

    @Test
    public void getBooksLater() {
        assertTrue("Arrays are not equal", java.util.Arrays.equals(later, books.getBooksLater(2010)));
    }

    @Test
    public void sort() {
        assertTrue("Arrays are not equal", java.util.Arrays.equals(sort, books.sort(new PublisherComparator())));
    }
}