package com.epam.task61.controller.command;

import com.epam.task61.util.InputUtility;

public class FindAuthorsCommand extends Command {
    @Override
    public String execute() {
        return serviceBooks.searchBooksByAuthor(
                            InputUtility.inputString(view, manager));
    }
}
