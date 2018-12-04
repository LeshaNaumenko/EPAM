package com.epam.task61.model.dao;


import com.epam.task61.MyConnectionDB;
import com.epam.task61.model.entity.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<T, C, I> {

    protected Connection conABS;

    public AbstractDAO(MyConnectionDB connection) {
        this.conABS = connection.getMyConnection();
    }
    public abstract Book[] findAll();
    public abstract Book[] searchBooksBy(C column, C value);
    public abstract Book[] findMoreThan(C column, I value);
    public abstract Book[] sortBy(C column);

    public void close(Statement statement){
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                //logger.error("Error: the connection tries to close: "+e.getMessage());
            }
        }
    }
    public void close(ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                e.printStackTrace();
                //logger.error("Error: the connection tries to close: "+e.getMessage());
            }
        }
    }
}
