package com.epam.task61.controller.command;

import com.epam.task61.exception.UnExistItemMenu;
import com.epam.task61.util.InputUtility;

public class ChangeLanguareCommand extends Command {
    @Override
    public String execute() {
        view.printMessage(manager.getMessage("LANGUARE"));
        while (true) {
            try {
                serviceBooks.changeLanguare(
                        InputUtility.inputInt(view, manager));
                break;
            } catch (UnExistItemMenu exp) {
                view.printError(exp.getMessage());
            }
        }
        return null;
    }
}
