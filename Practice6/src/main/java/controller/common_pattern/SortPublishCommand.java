package controller.common_pattern;

import static controller.common_pattern.CommandLogger.loggerCom;

public class SortPublishCommand extends Command{
    @Override
    public void execute() {
        loggerCom.info(" Menu selected: " + 5 + ". Description: Sort books by publisher");
        bookView.printBooks(resourceManager.getString("SORT"), bookService.getOrderedBooksByPublisher());

    }
}
