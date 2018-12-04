package com.epam.task61.model.dao;

import com.epam.task61.MyConnectionDB;
import com.epam.task61.model.entity.Book;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends AbstractDAO<Book, String, Integer> {
    Logger logger = Logger.getLogger(BookDAO.class.getName());

    public BookDAO(MyConnectionDB connection) {
        super(connection);
    }

    @Override
    public Book[] findAll() {
        Book[] books = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            try {
                statement = conABS.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM Book");
                List<Book> bookFromDB = createBookFromDB(resultSet);
                books = saveToArray(bookFromDB);
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        } finally {
            close(resultSet);
            close(statement);
        }
        return books;
    }

    private Book[] saveToArray(List<Book> bookFromDB) {
        Book[] localeBooks = new Book[bookFromDB.size()];
        return bookFromDB.toArray(localeBooks);
    }

    @Override
    public Book[] searchBooksBy(String column, String value) {
        Book[] books = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try {
                preparedStatement = conABS.prepareStatement("SELECT * FROM Book where " + column + "=?");
                preparedStatement.setString(1, value);
                resultSet = preparedStatement.executeQuery();
                List<Book> bookFromDB =  createBookFromDB(resultSet);
                books = saveToArray(bookFromDB);
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }

        } finally {
            close(resultSet);
            close(preparedStatement);
        }
        return books;
    }

    @Override
    public Book[] findMoreThan(String column, Integer value) {
        Book[] books = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try {
                preparedStatement = conABS.prepareStatement("SELECT * FROM Book where " + column + " > ?");
                preparedStatement.setInt(1, value);
                resultSet = preparedStatement.executeQuery();
                List<Book> bookList  = createBookFromDB(resultSet);
                books = saveToArray(bookList);
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        } finally {
            close(resultSet);
            close(preparedStatement);
        }
        return books;
    }

    @Override
    public Book[] sortBy(String column) {
        Book[] books = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            try {
                statement = conABS.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM Book ORDER BY " + column);
                List<Book> bookList = createBookFromDB(resultSet);
                books = saveToArray(bookList);
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        } finally {
            close(resultSet);
            close(statement);
        }
        return books;
    }

    private List<Book> createBookFromDB( ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            books.add(new Book(
                    resultSet.getInt(1),
                    resultSet.getString(2),//String titul
                    resultSet.getString(3),//String author
                    resultSet.getString(4),// String publish
                    resultSet.getInt(5),// int year
                    resultSet.getInt(6),//int pages
                    resultSet.getDouble(7) //double price
            ));
        }
        return books;
    }
    public boolean insert(Book[] list) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conABS.prepareStatement(
                    "INSERT INTO book (titul,author, publish, year,pages,price) VALUES (?,?,?,?,?,?)");
            for (Book book : list) {
                preparedStatement.setString(1, book.getTitul());//String titul
                preparedStatement.setString(2, book.getAuthor());//String author
                preparedStatement.setString(3, book.getPublish());// String publish
                preparedStatement.setInt(4, book.getYear());//   int year
                preparedStatement.setInt(5, book.getPages());//  int pages
                preparedStatement.setDouble(6, book.getPrice());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}