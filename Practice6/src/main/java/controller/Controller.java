package controller;

import controller.service.IOService;
import controller.service.Service;
import data.DataSource;
import location.ResourceManager;
import model.Books;
import model.entity.Book;
import org.apache.log4j.Logger;
import utility.InputOutputFile;
import view.*;

import java.io.IOException;
import java.util.Locale;


public class Controller {
    static Logger logger = Logger.getLogger(Controller.class);

    private BooksView bookView;
    private Service bookService;
    private IOService IObookService;
    private InputUtility utility;
    private ResourceManager resourceManager;


    public Controller(Books model, BooksView bookView, Service bookService, IOService IObookService, InputUtility utility, ResourceManager resourceManager) {
        this.utility = utility;
        this.bookView = bookView;
        this.bookService = bookService;
        this.IObookService = IObookService;
        this.bookService.setModel(model);
        this.resourceManager = resourceManager;
        this.utility.setView(bookView, resourceManager);
    }

    public void run() {
        bookView.printMessage(resourceManager.getString("MENU_INTERNATIONALIZATION"));
        resourceManager.changeResource(getLocal());
        bookService.setBooks(DataSource.getBooks());
        logger.warn(" Books are set by default.");
        while (true) {
            bookView.printMessage(resourceManager.getString("MENU"));
            MainMenuItem mainMenuItem = getMainMenuItem();
            switch (mainMenuItem) {
                case SHOW_BOOKS:
                    logger.info(" Menu selected: " + 1 + ". Description: Origin book array");
                    bookView.printBooks(resourceManager.getString("ALL"), bookService.getBooks());
                    continue;
                case FIND_AUTHOR:
                    logger.info(" Menu selected: " + 2 + ". Description: All the books of a certain author");
                    bookView.printMessage(resourceManager.getString("ENTER_NAME_OF_AUTHOR"));
                    String author = utility.getLine();
                    searchBooksBy(bookService.getByAuthor(author), resourceManager.getString("BY_AUTHOR"), author);
                    continue;
                case FIND_PUBLISHER:
                    logger.info(" Menu selected: " + 3 + ". Description: All the books of a certain publisher ");
                    bookView.printMessage(resourceManager.getString("ENTER_NAME_OF_PUBLISHER"));
                    String publisher = utility.getLine();
                    searchBooksBy(bookService.getByPublisher(publisher), resourceManager.getString("BY_PUBLISHER"), publisher);
                    continue;
                case FIND_YEAR:
                    logger.info(" Menu selected: " + 4 + ". Description: Books published after a certain year");
                    bookView.printMessage(resourceManager.getString("ENTER_A_YEAR"));
                    int tempValue = utility.getPosNumber();
                    searchBooksBy(bookService.getBooksLater(tempValue), resourceManager.getString("ALL_BOOKS_LATER"), Integer.toString(tempValue));
                    continue;
                case SORT_PUBLISH:
                    logger.info(" Menu selected: " + 5 + ". Description: Sort books by publisher");
                    bookView.printBooks(resourceManager.getString("SORT"), bookService.getOrderedBooksByPublisher());
                    continue;
                case READ_FROM_TXT:
                    logger.info(" Menu selected: " + 6 + ". Description: Read from file(.txt) and set to model");
                    bookService.setBooks(Service.createBooks(InputOutputFile.readFromTXT(utility.getPath())));
                    break;
                case READ_FROM_JSON:
                    logger.info(" Menu selected: " + 7 + ". Description: Read from file(.json) and set to model");
                    bookService.setBooks(InputOutputFile.readFromJSON(utility.getPath()));
                    break;
                case WRITE_TO_SER:
                    logger.info(" Menu selected: " + 8 + ". Description: Write to file (.ser)");

                    InputOutputFile.writeToFileSer(bookService.getModel(), utility.getPath());
//                        logger.error(e);
//                        e.printStackTrace();
//                        bookView.printMessage(resourceManager.getString("WRONG_PATH"));
                    continue;
                case WRITE_TO_TXT:
                    //don't forget to do
                    InputOutputFile.writeToTXT(bookService.getModel(), utility.getPath());
                    logger.info(" Menu selected: " + 9 + ". Description: Write to file (.txt)");
                    break;
                case EXIT:
                    logger.info(" User completed");
                    System.exit(0);
                default:
                    logger.warn(resourceManager.getString("WRONG_INPUT_INT_DATA"));
                    bookView.printMessage(resourceManager.getString("WRONG_INPUT_INT_DATA") + "\n");
                    break;
            }
        }
    }

    private Locale getLocal() {
        while (true) {
            LocaleMenuItem localeMenuItem = getLocaleMenuItem();
            switch (localeMenuItem) {
                case ENG:
                    logger.info(" Language selected: " + "English");
                    return new Locale("en", "US");
                case UA:
                    logger.info(" Language selected: " + "Ukrainian");
                    return new Locale("uk", "UK");
                case RU:
                    logger.info(" Language selected: " + "Russian");
                    return new Locale("ru", "RU");
                case EXIT:
                    logger.info("User completed");
                    System.exit(0);
                default:
                    logger.warn(resourceManager.getString("WRONG_INPUT_INT_DATA"));
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

    private MainMenuItem getMainMenuItem() {
        int input = utility.getPosNumber();
        MainMenuItem[] values = MainMenuItem.values();
        if (input < 0 || input > values.length) {
            return MainMenuItem.DEFAULT;
        }
        return values[input];
    }

    private LocaleMenuItem getLocaleMenuItem() {
        int input = utility.getPosNumber();
        LocaleMenuItem[] values2 = LocaleMenuItem.values();
        if (input < 0 || input > values2.length) {
            return LocaleMenuItem.DEFAULT;
        }
        return values2[input];
    }
}