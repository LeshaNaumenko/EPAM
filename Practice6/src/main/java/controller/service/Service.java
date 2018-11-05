package controller.service;

import model.PublisherComparator;
import model.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class Service extends AbsService {


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
        return books1.toArray(new Book[books1.size()]);
    }
}
