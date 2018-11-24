package controller.common_pattern;

import static controller.Controller.searchBooksBy;
import static controller.common_pattern.CommandLogger.loggerCom;

public class FindYearCommand extends Command{
    @Override
    public void execute() {
        loggerCom.info(" Menu selected: " + 4 + ". Description: Books published after a certain year");
        bookView.printMessage(resourceManager.getString("ENTER_A_YEAR"));
        int tempValue = utility.getPosNumber();
        searchBooksBy(bookService.getBooksLater(tempValue), resourceManager.getString("ALL_BOOKS_LATER"), Integer.toString(tempValue), bookView,resourceManager);
    }
}
