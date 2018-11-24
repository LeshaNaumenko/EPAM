package controller.common_pattern;

import static controller.Controller.searchBooksBy;
import static controller.common_pattern.CommandLogger.loggerCom;

public class FindAuthorCommand extends Command{
    @Override
    public void execute() {
        loggerCom.info(" Menu selected: " + 2 + ". Description: All the books of a certain author");
        String enter_name_of_author = resourceManager.getString("ENTER_NAME_OF_AUTHOR");
        bookView.printMessage(enter_name_of_author);
        String author = utility.getLine();
        searchBooksBy(bookService.getByAuthor(author), resourceManager.getString("BY_AUTHOR"), author, bookView,resourceManager );
    }
}
