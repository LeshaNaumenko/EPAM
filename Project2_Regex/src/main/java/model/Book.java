package model;

/**
 * The {@code Book} class represents an entity that is model
 *
 * @author Alex Naumenko
 * @version 1.0
 */
public class Book {
    /**
     * Text book
     */
    private String text;


    /**
     * Constructs a new Book object with text.
     */
    public Book(String text) {
        this.text = text;
    }

    /**
     * Returns the text of the book
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Parameter text to set one for current book.
     * @param text
     */

    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns a string representation of the Book object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return text;
    }
}
