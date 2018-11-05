package data;


import controller.service.Service;
import model.entity.Book;

public class DataSource {
    public static Book[] getBooks() {
        String books = "Title1, Shevchenko, BXV, 2010, 320, 450.0\n"+
                          "Title2, Shevchenko, Word, 2000, 120, 250.0\n"+
                          "Title3, Sokolov,    BXV, 1999, 820, 1050.0\n"+
                          "Title4, Maslov, Piter, 2016, 555, 620.5\n"+
                          "Title5, Sokolov, Piter, 2011, 876, 555.5\n"+
                          "Title6, Sokolov, BXV, 2001, 400, 300.0\n"+
                          "Title7, Petrov, Zord, 2018, 276, 155.5\n"+
                          "Title8, Shevchenko, Piter, 2013, 456, 100.0";
        return Service.createBooks(books);
    }
}
