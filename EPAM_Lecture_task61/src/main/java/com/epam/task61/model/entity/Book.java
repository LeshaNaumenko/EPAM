package com.epam.task61.model.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private static int nextId = 0;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    private String titul;
    private String author;
        private String publish;
    private int year;
    private int pages;
    private double price;

    {        this.id = nextId++;    }

    public int getId() {
        return id;
    }
    public String getTitul() {
        return titul;
    }
    public void setTitul(String titul) {
        this.titul = titul;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("author:%-15s titul:%-25s publish:%-15s year:%-5d " +
                        "pages:%-5d cost:%-7.2f", author, titul, publish, year,
                pages, price);
    }

    public Book() {    }

    public Book(String titul, String author) {
        this.titul = titul;
        this.author = author;
    }

    public Book(int id, String titul, String author, String publish, int year,
                int pages, double price) {
        this.id = id;
        this.titul = titul;
        this.author = author;
        this.publish = publish;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }
    public Book(String titul, String author, String publish, int year,
                int pages, double price) {

        this.titul = titul;
        this.author = author;
        this.publish = publish;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    public Book(String titul, String autor, double price) {
        this.titul = titul;
        this.author = autor;
        this.price = price;
    }
}
