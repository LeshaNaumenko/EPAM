package view;

import location.ResourceManager;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtility {
    static Logger logger = Logger.getLogger(InputUtility.class);

    static {
        FileAppender fileAppender;
        try {
            fileAppender = new FileAppender(new SimpleLayout(), "log.txt");
            logger.addAppender(fileAppender);
            logger.setLevel(Level.DEBUG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Scanner scanner;
    private BooksView booksView;
    private ResourceManager resourceManager;

    public void setView(BooksView booksView, ResourceManager resourceManager) {
        this.booksView = booksView;
        this.resourceManager = resourceManager;
    }

    public String  getPath() {
        scanner = new Scanner(System.in);
        booksView.printMessage(resourceManager.getString("ENTER_A_PATH"));
        Pattern compile = Pattern.compile("((\\w{1}:\\\\(([A-z]|[0-9]|\\s)+)\\\\\\w+\\.\\w+))|(\\w{1}:\\\\(\\w+\\.\\w+))");
        String temp;
        while (!(temp = scanner.nextLine()).equals("n")) {
            Matcher m = compile.matcher(temp);
            if (m.find()) {
                break;
            }
            logger.warn(resourceManager.getString("WRONG_INPUT_INT_DATA"));
            booksView.printMessage(resourceManager.getString("WRONG_INPUT_INT_DATA"));
        }
        logger.info("Result is " + temp);
        return temp;
    }

    public String getLine() {
        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        logger.info("Result is " + s);
        return s;
    }

    public int getPosNumber() {
        scanner = new Scanner(System.in);
        int input;
        while (true) {
            booksView.printMessage(resourceManager.getString("POSITIVE"));
            if (!scanner.hasNextInt()) {
                logger.warn(resourceManager.getString("WRONG_INPUT_INT_DATA"));
                booksView.printMessage(resourceManager.getString("WRONG_INPUT_INT_DATA"));
                scanner.next();
                continue;
            }
            input = scanner.nextInt();
            if (input < 0) {
                logger.warn(resourceManager.getString("WRONG_INPUT_INT_DATA"));
                booksView.printMessage(resourceManager.getString("WRONG_INPUT_INT_DATA"));
                continue;
            }
            logger.debug("Result is " + input);
            return input;
        }
    }
}
