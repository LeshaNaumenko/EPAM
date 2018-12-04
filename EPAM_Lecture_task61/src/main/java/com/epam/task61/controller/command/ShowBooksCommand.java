package com.epam.task61.controller.command;

public class ShowBooksCommand extends Command {
    @Override
    public String execute() {
        view.printMessage(manager.getMessage("listBooks"));
        return serviceBooks.showAllBooks();
    }
}
