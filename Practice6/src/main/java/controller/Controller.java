package controller;

import controller.service.IOService;
import controller.service.Service;
import data.DataSource;
import model.Books;
import model.entity.Book;
import view.BooksView;
import view.ConstantMessage;
import view.InputUtility;
import view.Menu;

import java.io.IOException;


public class Controller {
    private BooksView bookView;
    private Service bookService;
    private IOService IObookService;
    private InputUtility utility;


    public Controller(Books model, BooksView bookView, Service bookService, IOService IObookService, InputUtility utility) {
        this.utility = utility;
        this.bookView = bookView;
        this.bookService = bookService;
        this.IObookService = IObookService;
        this.bookService.setModel(model);
        this.utility.setView(bookView);
    }

    public void run() {
        bookService.setBooks(DataSource.getBooks());
        while (true) {
            bookView.printMessage(Menu.MENU);
            int input = utility.getPosNumber();
            switch (input) {
                case 1:
                    bookView.printBooks(ConstantMessage.ALL, bookService.getBooks());
                    continue;
                case 2:
                    bookView.printMessage(ConstantMessage.ENTER_NAME_OF_AUTHOR);
                    String author = utility.getLine();
                    searchBooksBy(bookService.getByAuthor(author), ConstantMessage.BY_AUTHOR, author);
                    continue;
                case 3:
                    bookView.printMessage(ConstantMessage.ENTER_NAME_OF_PUBLISHER);
                    String publisher = utility.getLine();
                    searchBooksBy(bookService.getByPublisher(publisher), ConstantMessage.BY_PUBLISHER, publisher);
                    continue;
                case 4:
                    bookView.printMessage(ConstantMessage.ENTER_A_YEAR);
                    int tempValue = utility.getPosNumber();
                    searchBooksBy(bookService.getBooksLater(tempValue), ConstantMessage.ALL_BOOKS_LATER, Integer.toString(tempValue));
                    continue;
                case 5:
                    bookView.printBooks(ConstantMessage.SORT, bookService.getOrderedBooksByPublisher());
                    continue;
                case 6:
                    while (true) {
                        try {
                            bookService.setBooks(Service.createBooks(IObookService.readFromFile(utility.getPath())));
                            break;
                        } catch (IOException e) {
                            bookView.printMessage(ConstantMessage.WRONG_PATH);
                        } catch (Exception e) {
                            bookView.printMessage(ConstantMessage.WRONG_PATH);
                        }
                    }
                    continue;
                case 7:
                    try {
                        IObookService.writeToFileSer(bookService.getModel(), utility.getPath());
                    } catch (IOException e) {
                        bookView.printMessage(ConstantMessage.WRONG_PATH);
                    }
                    continue;
                case 0:
                    System.exit(0);
                default:
                    bookView.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA + "\n");
                    break;
            }
        }
    }

    private void searchBooksBy(Book[] result, String message, String input) {
        if (result.length == 0) {
            bookView.printMessage(ConstantMessage.NO_BOOKS + input);
        } else {
            bookView.printBooks(message + "\"" + input + "\":", result);
        }
    }
}
