package controller.common_pattern;

import controller.service.Service;
import location.ResourceManager;
import view.BooksView;
import view.InputUtility;

public abstract class Command {
    protected Service bookService;
    protected BooksView bookView;
    protected InputUtility utility;
    protected ResourceManager resourceManager;

    public void setUtilityForCommand(Service bookService, BooksView bookView, InputUtility utility, ResourceManager resourceManager) {
        this.bookService = bookService;
        this.bookView = bookView;
        this.utility = utility;
        this.resourceManager = resourceManager;
    }

    public abstract void execute();
}
