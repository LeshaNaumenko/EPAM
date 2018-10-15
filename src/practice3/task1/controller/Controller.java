package practice3.task1.controller;

import practice3.task1.data.DataSource;
import practice3.task1.model.GameRoom;
import practice3.task1.model.entity.Toy;
import practice3.task1.view.ViewToy;
import java.util.Scanner;

public class Controller {
    GameRoom<Toy> model = new GameRoom<>();
    ViewToy view = new ViewToy();

    public void run() {
        model.setToys(DataSource.getToys());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.printMessage(
                         "Original list of toys                  -       press 1\n" +
                            "Sort by price                          -       press 2\n" +
                            "Total value of toys                    -       press 3\n" +
                            "Get the toys in the specified range    -       press 4\n" +
                            "Exit                                   -       press 0\n"
            );
            view.printMessage(">>");
            if (scanner.hasNextInt()) {
                int valueInt = scanner.nextInt();
                switch (valueInt) {
                    case 1:
                        view.printList("All toys:", model.getToys());
                        continue;
                    case 2:
                        view.printList("", model.sortByPrice());
                        continue;
                    case 3:
                        view.printResult(view.TOTAL_VALUE_OF_TOYS, model.getSumOfPrice());
                        continue;
                    case 4:
                        int input;
                        while (true) {
                            view.printMessage("Enter a positive range");
                            view.printMessage(">>");
                            if (!scanner.hasNextInt()) {
                                view.printMessage(view.WRONG_INPUT_INT_DATA);
                                scanner.next();
                                continue;
                            }
                            input = scanner.nextInt();
                            if (input <= 0) {
                                view.printMessage(view.WRONG_INPUT_INT_DATA);
                                continue;
                            }
                            break;
                        }
                        getListByParam(input);
                        continue;
                    case 0:
                        System.exit(0);
                    default:
                        view.printMessage(view.WRONG_INPUT_INT_DATA + "\n");
                }
            } else {
                view.printMessage(view.WRONG_INPUT_INT_DATA + "\n");
                scanner.next();
            }
        }
    }

    private void getListByParam(int input) {
        switch (input) {
            case 5:
                hasItem(input, model.getFourParam());
                break;
            case 6:
                hasItem(input, model.getFiveParam());
                break;
            case 7:
                hasItem(input, model.getSixParam());
                break;
            default:
                view.printMessage("No toys");
                break;
        }
    }

    private void hasItem(int input, Toy[] list) {
        if (list.length == 0) {
            view.printMessage("No toys");
        } else view.printList("Toys that have " + input + " parameter(s)", list);
    }
}

