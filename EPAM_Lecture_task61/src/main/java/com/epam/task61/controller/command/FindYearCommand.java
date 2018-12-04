package com.epam.task61.controller.command;

import com.epam.task61.util.InputUtility;

public class FindYearCommand extends Command {
    @Override
    public String execute() {
        return serviceBooks.searchBooksAfterYear(
                            InputUtility.inputInt(view, manager));
    }
}
