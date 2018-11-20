package controller;

import controller.service.IOService;
import controller.service.Service;
import data.DataSource;
import location.ResourceManager;
import model.Books;
import model.entity.Book;
import org.apache.log4j.Logger;
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
            int input = utility.getPosNumber();
            switch (input) {
                case 1:
                    logger.info(" Menu selected: " + 1 + ". Description: Origin book array");
                    bookView.printBooks(resourceManager.getString("ALL"), bookService.getBooks());
                    continue;
                case 2:
                    logger.info(" Menu selected: " + 2 + ". Description: All the books of a certain author");
                    bookView.printMessage(resourceManager.getString("ENTER_NAME_OF_AUTHOR"));
                    String author = utility.getLine();
                    searchBooksBy(bookService.getByAuthor(author), resourceManager.getString("BY_AUTHOR"), author);
                    continue;
                case 3:
                    logger.info(" Menu selected: " + 3 + ". Description: All the books of a certain publisher ");
                    bookView.printMessage(resourceManager.getString("ENTER_NAME_OF_PUBLISHER"));
                    String publisher = utility.getLine();
                    searchBooksBy(bookService.getByPublisher(publisher), resourceManager.getString("BY_PUBLISHER"), publisher);
                    continue;
                case 4:
                    logger.info(" Menu selected: " + 4 + ". Description: Books published after a certain year");
                    bookView.printMessage(resourceManager.getString("ENTER_A_YEAR"));
                    int tempValue = utility.getPosNumber();
                    searchBooksBy(bookService.getBooksLater(tempValue), resourceManager.getString("ALL_BOOKS_LATER"), Integer.toString(tempValue));
                    continue;
                case 5:
                    logger.info(" Menu selected: " + 5 + ". Description: Sort books by publisher");
                    bookView.printBooks(resourceManager.getString("SORT"), bookService.getOrderedBooksByPublisher());
                    continue;
                case 6:
                    logger.info(" Menu selected: " + 6 + ". Description: Read from file(.txt) and set to model");
                    while (true) {
                        try {
                            bookService.setBooks(Service.createBooks(IObookService.readFromTXT(utility.getPath())));
                            break;
                        } catch (IOException e) {
                            logger.error(e);
                            System.err.println(e);
//                            e.printStackTrace();
                        } catch (Exception e) {
                            logger.error(e);
                            System.err.println(e);
//                            e.printStackTrace();
                        }
                    }
                    continue;
                case 7:
                    logger.info(" Menu selected: " + 7 + ". Description: Read from file(.json) and set to model");
                    bookService.setBooks(IObookService.readFromJSON(utility.getPath()));
                    break;
                case 8:
                    logger.info(" Menu selected: " + 8 + ". Description: Write to file (.ser)");
                    try {
                        IObookService.writeToFileSer(bookService.getModel(), utility.getPath());
                    } catch (IOException e) {
                        logger.error(e);
                        e.printStackTrace();
                        bookView.printMessage(resourceManager.getString("WRONG_PATH"));
                    }
                    continue;
                case 9:
                    logger.info(" Menu selected: " + 9 + ". Description: Write to file (.txt)");

                    break;
                case 0:
                    logger.info(" User completed");
                    System.exit(0);
                default:
                    logger.warn(resourceManager.getString(" WRONG_INPUT_INT_DATA"));
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
                    logger.info(" Language selected: " + "English");
                    return new Locale("en", "US");
                case 2:
                    logger.info(" Language selected: " + "Ukrainian");
                    return new Locale("uk", "UK");
                case 3:
                    logger.info(" Language selected: " + "Russian");
                    return new Locale("ru", "RU");
                case 0:
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
}