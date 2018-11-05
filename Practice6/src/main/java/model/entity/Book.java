package model.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private String author;
    private String publisher;
    private int year;
    private int pages;
    private double price;

    private Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        if (year != book.year) return false;
        if (pages != book.pages) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (!name.equals(book.name)) return false;
        if (!author.equals(book.author)) return false;
        return publisher.equals(book.publisher);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + year;
        result = 31 * result + pages;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

//    private Book(Builder builder) {
//        this.name = builder.name;
//        this.author = builder.author;
//        this.publisher = builder.publisher;
//        this.year = builder.year;
//        this.pages = builder.pages;
//        this.price = builder.price;
//    }

    @Override
    public String toString() {
        return String.format("%-4s{" +
                        "name=%-5s" +
                        ", author=%-10s" +
                        ", publisher=%-5s" +
                        ", year=%-4s" +
                        ", pages=%-3s" +
                        ", price=%-7s" +
                        '}',
                this.getClass().getSimpleName(), name, author, publisher, year, pages, price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public static Builder newBuilder() {
        return new Book().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setName(String name) {
            Book.this.name = name;
            return this;
        }

        public Builder setAuthor(String author) {
            Book.this.author = author;
            return this;
        }

        public Builder setPublisher(String publisher) {
            Book.this.publisher = publisher;
            return this;
        }

        public Builder setYear(int year) {
            Book.this.year = year;
            return this;
        }

        public Builder setPages(int pages) {
            Book.this.pages = pages;
            return this;
        }

        public Builder setPrice(double price) {
            Book.this.price = price;
            return this;
        }

        public Book build() {
            return Book.this;
        }
    }

}
