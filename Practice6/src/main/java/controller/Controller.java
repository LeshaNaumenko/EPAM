package controller;

import controller.service.IOService;
import controller.service.Service;
import data.DataSource;
import location.ResourceManager;
import model.Books;
import model.entity.Book;
import view.*;

import java.io.IOException;
import java.util.Locale;


public class Controller {
    private BooksView bookView;
    private Service bookService;
    private IOService IObookService;
    private InputUtility utility;
    private ResourceManager resourceManager;



    public Controller(Books model, BooksView bookView, Service bookService, IOService IObookService, InputUtility utility,ResourceManager resourceManager) {
        this.utility = utility;
        this.bookView = bookView;
        this.bookService = bookService;
        this.IObookService = IObookService;
        this.bookService.setModel(model);
        this.resourceManager = resourceManager;
        this.utility.setView(bookView,resourceManager);
    }

    public void run() {
        bookView.printMessage(ManuLanguage.MENU_INTERNATIONALIZATION);
        resourceManager.changeResource(getLocal());
        bookService.setBooks(DataSource.getBooks());
        while (true) {
            bookView.printMessage(resourceManager.getString("MENU"));
            int input = utility.getPosNumber();
            switch (input) {
                case 1:
                    bookView.printBooks(resourceManager.getString("ALL"), bookService.getBooks());
                    continue;
                case 2:
                    bookView.printMessage(resourceManager.getString("ENTER_NAME_OF_AUTHOR"));
                    String author = utility.getLine();
                    searchBooksBy(bookService.getByAuthor(author), resourceManager.getString("BY_AUTHOR"), author);
                    continue;
                case 3:
                    bookView.printMessage(resourceManager.getString("ENTER_NAME_OF_PUBLISHER"));
                    String publisher = utility.getLine();
                    searchBooksBy(bookService.getByPublisher(publisher), resourceManager.getString("BY_PUBLISHER"), publisher);
                    continue;
                case 4:
                    bookView.printMessage(resourceManager.getString("ENTER_A_YEAR"));
                    int tempValue = utility.getPosNumber();
                    searchBooksBy(bookService.getBooksLater(tempValue), resourceManager.getString("ALL_BOOKS_LATER"), Integer.toString(tempValue));
                    continue;
                case 5:
                    bookView.printBooks(resourceManager.getString("SORT"), bookService.getOrderedBooksByPublisher());
                    continue;
                case 6:
                    while (true) {
                        try {
                            bookService.setBooks(Service.createBooks(IObookService.readFromTXT(utility.getPath())));
                            break;
                        } catch (IOException e) {
                            System.err.println(e);
//                            e.printStackTrace();
                        } catch (Exception e) {
                            bookView.printMessage("You have some problems.");
                            System.err.println(e);
//                            e.printStackTrace();
                        }
                    }
                    continue;
                case 7:
                    bookService.setBooks(IObookService.readFromJSON(utility.getPath()));
                    break;
                case 8:
                    try {
                        IObookService.writeToFileSer(bookService.getModel(), utility.getPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                        bookView.printMessage(resourceManager.getString("WRONG_PATH"));
                    }
                    continue;
                case 9:

                    break;
                case 0:
                    System.exit(0);
                default:
                    bookView.printMessage(resourceManager.getString("WRONG_INPUT_INT_DATA") + "\n");
                    break;
            }
        }
    }

    private Locale getLocal() {
        while (true) {
            int language = utility.getPosNumber();
            switch (language) {
                case 1:
                    return new Locale("en", "US");
                case 2:
                    return new Locale("uk", "UK");
                case 3:
                    return new Locale("ru", "RU");
                case 0:
                    System.exit(0);
                default:
                    bookView.printMessage(resourceManager.getString("WRONG_INPUT_INT_DATA") + "\n");
                    break;

            }
        }
    }

    private void searchBooksBy(Book[] result, String message, String input) {
        if (result.length == 0) {
            bookView.printMessage(resourceManager.getString("NO_BOOKS") + input);
        } else {
            bookView.printBooks(message + "\"" + input + "\":", result);
        }
    }
}