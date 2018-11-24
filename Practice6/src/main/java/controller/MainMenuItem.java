package controller;

import controller.common_pattern.*;
import controller.service.Service;
import location.ResourceManager;
import view.BooksView;
import view.InputUtility;

public enum MainMenuItem {
    EXIT(new ExitCommand()),
    SHOW_BOOKS(new ShowBooksCommand()),
    FIND_AUTHOR(new FindAuthorCommand()),
    FIND_PUBLISHER(new FindPublisherCommand()),
    FIND_YEAR(new FindYearCommand()),
    SORT_PUBLISH(new SortPublishCommand()),
    READ_FROM_TXT(new ReadFromTxtCommand()),
    READ_FROM_JSON(new ReadFromJsonCommand()),
    WRITE_TO_SER(new WriteToSerCommand()),
    WRITE_TO_TXT(new WriteToTxtCommand()),
    DEFAULT(new DefaultCommand());

    private Command command;

    public void set(Service bookService, BooksView bookView, InputUtility utility, ResourceManager resourceManager) {
        this.command.setUtilityForCommand(bookService, bookView,utility,resourceManager);
    }
    MainMenuItem(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
