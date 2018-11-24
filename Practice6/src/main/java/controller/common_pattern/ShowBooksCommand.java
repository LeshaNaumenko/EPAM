package controller.common_pattern;

import static controller.common_pattern.CommandLogger.loggerCom;

public class ShowBooksCommand extends Command {
    @Override
    public void execute() {
        loggerCom.info(" Menu selected: 1. Description: Origin book array");
        bookView.printBooks(resourceManager.getString("ALL"), bookService.getBooks());
    }

}
