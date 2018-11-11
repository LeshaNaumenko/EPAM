package controller;

import controller.service.ServiceWordProcessing;
import view.*;

import java.io.IOException;

public class Controller {

    ServiceWordProcessing service;
    ViewWordProcessing view;
    InputUtility utility;

    public Controller(ServiceWordProcessing service, ViewWordProcessing view, InputUtility utility) {
        this.service = service;
        this.view = view;
        this.utility = utility;
        utility.setViewWordProcessing(view);
    }

    public void run() {
        view.printMessage(ConstantsMessage.STARTING);

        while (true) {
            view.printMessage(MainMenu.MENU);
            int posNumber = utility.getPosNumber(ConstantsMessage.POSITIVE);
            switch (posNumber) {
                case 1:
                    try {
                        String text = service.getModelFromFile(utility.getPath());
                        service.setModel(service.createModel(text));
                        runSubMenu();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    continue;
                case 2:
                    service.setModel(service.createModel(utility.getText()));
                    runSubMenu();
                    continue;
                case 0:
                    System.exit(0);
                default:
                    view.printMessage(ConstantsMessage.WRONG_INPUT_INT_DATA);
            }
        }
    }

    private void runSubMenu() {

        while (true) {
            view.printMessage(SubMenu.SUB_MENU);
            int posNumber = utility.getPosNumber(ConstantsMessage.POSITIVE);
            switch (posNumber) {
                case 1:
                    int length = utility.getPosNumber(ConstantsMessage.LENGTH);
                    view.printMessage(ConstantsMessage.RESULT);
                    view.printMessage(service.textHandling(service.getModel().getText(), length));
                    continue;
                case 0:
                    return;
                default:
                    view.printMessage(ConstantsMessage.WRONG_INPUT_INT_DATA);
            }
        }
    }
}
