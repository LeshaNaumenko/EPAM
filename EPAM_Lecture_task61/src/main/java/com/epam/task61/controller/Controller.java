package com.epam.task61.controller;

import com.epam.task61.controller.command.Command;
import com.epam.task61.controller.command.ItemMenu;
import com.epam.task61.util.InputUtility;
import com.epam.task61.util.ResourceManager;
import com.epam.task61.view.BookView;
import com.epam.task61.exception.UnExistItemMenu;

public class Controller {
    ResourceManager manager = ResourceManager.INSTANCE;
    private BookView view = new BookView();

    public void run() {
        while (true) {
            try {
                view.printMessage(manager.getMessage("mainMenu"));
                int number = InputUtility.inputInt(view, manager);
                Command command = defineCommand(number);
                view.printMessage(command.execute());
            } catch (UnExistItemMenu exp) {
                view.printError(exp.getMessage());
            }
        }
    }
    private Command defineCommand(int number) throws UnExistItemMenu {
        ItemMenu[] itemMenus = ItemMenu.values();
        if (number < 0 || number >= itemMenus.length) {
            throw new UnExistItemMenu(manager.getMessage("WRONG_INPUT_DATA"));
        }
        return itemMenus[number].getCommand();
    }
}
