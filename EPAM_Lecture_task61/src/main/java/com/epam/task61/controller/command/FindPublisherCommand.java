package com.epam.task61.controller.command;

import com.epam.task61.util.InputUtility;

public class FindPublisherCommand extends Command {
    @Override
    public String execute() {
        return serviceBooks.searchBooksByPublisher(
                            InputUtility.inputString(view, manager));
    }
}
