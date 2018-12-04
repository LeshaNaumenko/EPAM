package com.epam.task61.model.data;

import com.epam.task61.model.entity.Book;

public class DataSource {
    public static Book[] getBooks(){
        return new Book[]{
                new Book("Book 1","Shevchenko","ABABAGALAMAGA",2010,100,150.0),
                new Book("Java","Lenin","Kharkiv",2008,150,40.0),
                new Book("HTML","WWW consortium","Kyiv",2001,130,225.0),
                new Book("CSS","WWW consortium","Odessa",2018,333,26.0),
                new Book("JavaScript","WWW consortium","Lviv",2011,726,86.0),
                new Book("Python","Herbert Shild","Lviv",2011,376,86.0),
                new Book("Title1", "Shevchenko","BXV", 2010, 320, 450.0),
                new Book("Title2", "Shevchenko","Word", 2000, 120, 250.0),
                new Book("Title3", "Sokolov","BXV", 1999, 820, 1050.0),
                new Book("Title4", "Maslov","Piter", 2016, 555, 620.5),
                new Book("Title5", "Sokolov","Piter", 2011, 876, 555.5),
                new Book("Title6", "Alexandrov","BXV", 2001, 400, 300.0),
                new Book("Title7", "Petrov","Word", 2018, 276, 155.5),
                new Book("Title8", "Shevchenko","Piter", 2013, 456, 100.0),
        };
    }
}
