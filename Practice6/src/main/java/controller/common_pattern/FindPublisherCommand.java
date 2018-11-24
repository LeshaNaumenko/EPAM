package controller.common_pattern;

import static controller.Controller.searchBooksBy;
import static controller.common_pattern.CommandLogger.loggerCom;

public class FindPublisherCommand extends Command{
    @Override
    public void execute() {
        loggerCom.info(" Menu selected: " + 3 + ". Description: All the books of a certain publisher ");
        bookView.printMessage(resourceManager.getString("ENTER_NAME_OF_PUBLISHER"));
        String publisher = utility.getLine();
        searchBooksBy(bookService.getByPublisher(publisher), resourceManager.getString("BY_PUBLISHER"), publisher,bookView,resourceManager );
    }
}
