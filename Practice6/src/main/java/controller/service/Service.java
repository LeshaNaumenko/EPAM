package controller.service;

import model.PublisherComparator;
import model.entity.Book;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service extends AbsService {

    public static final Logger logger = Logger.getLogger(Service.class);

    public Book[] getBooks() {
        Book[] books = model.getBooks();
        logger.trace("Return books: "+ Arrays.toString(books) );
        return books;
    }

    public void setBooks(Book[] books) {
        logger.trace("Initialize the model list of books: "+Arrays.toString(books) );
        model.setBooks(books);
    }

    public Book[] getByAuthor(String author) {
        Book[] byAuthor = model.getByAuthor(author);
        logger.trace("Return books by author \""+author+"\" : "+ Arrays.toString(byAuthor) );
        return byAuthor;
    }

    public Book[] getByPublisher(String publisher) {
        Book[] byPublisher = model.getByPublisher(publisher);
        logger.trace("Return books by publisher \""+publisher+"\" : "+ Arrays.toString(byPublisher) );
        return byPublisher;
    }

    public Book[] getBooksLater(int year) {
        Book[] booksLater = model.getBooksLater(year);
        logger.trace("Return books later \""+year+"\" : "+ Arrays.toString(booksLater) );
        return booksLater;
    }

    public Book[] getOrderedBooksByPublisher() {
        Book[] sort = model.sort(new PublisherComparator());
        logger.trace("Return Ordered Books By Publisher: "+ Arrays.toString(sort));
        return sort;
    }

    public static Book[] createBooks(String books) {
        String[] split = books.split("\\r?\\n");
        List<Book> books1 = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(",[ ]*");
            if (split1.length == 6) {
                books1.add(Book.newBuilder().setName(split1[0])
                        .setAuthor(split1[1])
                        .setPublisher(split1[2])
                        .setYear(Integer.valueOf(split1[3]))
                        .setPages(Integer.valueOf(split1[4]))
                        .setPrice(Double.valueOf(split1[5]))
                        .build());
            }
        }
        logger.trace("Create array of books using the builder pattern");
        return books1.toArray(new Book[books1.size()]);
    }
}
