package practice5.task3.controller;

import practice5.task3.model.Translator;
import practice5.task3.view.ConstantsMessageTranslator;
import practice5.task3.view.InputTools;
import practice5.task3.view.View;

import javax.swing.table.TableCellRenderer;

public class Controller {

    View view = new View();
    InputTools inputTools = new InputTools(view);
    Service service = new Service(new Translator());

    public void run() {
        int posNumber;

        while (true) {
            view.printMessage(View.MENU);
            posNumber = inputTools.getPosNumber();
            switch (posNumber) {
                case 1:
                    String translate = service.translate(inputTools.getLine());
                    view.printMessage(ConstantsMessageTranslator.TRANSLATION);
                    view.printMessage(translate);
                    break;
                case 2:
                    view.printMessage(ConstantsMessageTranslator.ENTER_WORDS);
                    String[] strings = inputTools.checkInputWords();
                    if (service.addWord(strings[0], strings[1])) {
                        view.printMessage(ConstantsMessageTranslator.SUCCESS);
                    } else {
                        view.printMessage(ConstantsMessageTranslator.ALREADY_EXISTS);
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    view.printMessage(ConstantsMessageTranslator.WRONG_INPUT_INT_DATA);
            }
        }

    }

    public static void main(String[] args) {
        new Controller().run();
    }

}
