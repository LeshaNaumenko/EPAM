package controller;

import controller.service.Service;
import data.DataSource;
import location.ResourceManager;
import model.Books;
import model.entity.Book;
import org.apache.log4j.Logger;
import view.*;

import java.util.Locale;


public class Controller {
    static Logger logger = Logger.getLogger(Controller.class);



    private BooksView bookView;
    private Service bookService;
    private InputUtility utility;
    private ResourceManager resourceManager;


    public Controller(Books model, BooksView bookView, Service bookService, InputUtility utility, ResourceManager resourceManager) {
        this.utility = utility;
        this.bookView = bookView;
        this.bookService = bookService;
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
            mainMenuItem.set(bookService, bookView, utility, resourceManager);
            mainMenuItem.getCommand().execute();
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

    public static void searchBooksBy(Book[] result, String message, String input,  BooksView bookView,ResourceManager resourceManager) {
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