package practice3.task2.controller;

import practice1.task1.view.View;
import practice3.task2.data.DataSource;
import practice3.task2.model.Shop;
import practice3.task2.model.entity.Goods;
import practice3.task2.view.ShopView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Shop model;
    private ShopView view;

    public Controller(Shop model, ShopView view) {
        this.model = model;
        this.view = view;
    }


    public void run() {

    Scanner scanner = new Scanner(System.in);
        while (true) {
            view.printMessageWithoutLn(
                    "Show all departments                   -       press 1\n" +
                            "Create department                      -       press 2\n" +
                            "Eliminate a department                 -       press 3\n" +
                            "Supply of goods                        -       press 4\n" +
                            "Show goods                             -       press 5\n" +
                            "Add location                           -       press 6\n" +
                            "Eliminate a location                   -       press 7\n" +
                            "Show locations                         -       press 8\n" +
                            "Reallocation of departments(sort)      -       press 9\n" +
                            "Exit                                   -       press 0\n>>");
            if (scanner.hasNextInt()) {
                int valueInt = scanner.nextInt();
                switch (valueInt) {
                    case 1:
                        getDepartments();
                        continue;
                    case 2:
                        createDepartments(scanner);
                        continue;
                    case 3:
                        deleteDep(scanner);
                        continue;
                    case 4:
                        supply(scanner);
                        continue;
                    case 5:
                        showGoods(scanner);
                        continue;
                    case 6:
                        addLocation(scanner);
                        continue;
                    case 7:
                        deleteLocationController(scanner);
                        continue;
                    case 8:
                        view.printMessage("All locations:");
                        view.printListOfLocations(model.getListOfLocation());
                        continue;
                    case 9:
                        reallocationByQuantityOfGoods(scanner);
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

    private void reallocationByQuantityOfGoods(Scanner scanner) {
        scanner = new Scanner(System.in);
        if(model.reallocation()){
            view.printMessage("reallocation committed successfully!");
        }else
            view.printMessage("reallocation doesn't committed!");
    }

    private void deleteLocationController(Scanner scanner) {
        scanner = new Scanner(System.in);
        view.printMessageWithoutLn("Location. ");
        Integer location = getPositive(scanner);
        if (model.deleteLocation(location)) {
            view.printMessage("Location deleted successfully!");
        }else
            view.printMessage("Location doesn't exists.");
    }

    private void addLocation(Scanner scanner) {
        scanner = new Scanner(System.in);
        view.printMessageWithoutLn("Location. ");
        Integer location = getPositive(scanner);
        if (model.addNewLocation(location)) {
            view.printMessage("Location added successfully!");
        }else
            view.printMessage("Location already exists");
    }

    private void showGoods(Scanner scanner) {
        scanner = new Scanner(System.in);
        view.printMessageWithoutLn("Enter name of department>>");
        String nameOfDepartment = scanner.nextLine();
        if (model.hasDepartment(nameOfDepartment)) {
            List<Goods> listOfGoods = model.getGoodsOfDepartment(nameOfDepartment);
            if (listOfGoods != null) {
                view.printListOfGoods(listOfGoods);
            } else
                view.printMessage("Department has no goods");
        } else
            view.printMessage("No department");
    }

    private boolean hasDepartmentController(Scanner scanner) {
        scanner = new Scanner(System.in);
        view.printMessageWithoutLn("Enter name of department>>");
        String nameOfDepartment = scanner.nextLine();
        return model.hasDepartment(nameOfDepartment);
    }

    private void supply(Scanner scanner) {
        scanner = new Scanner(System.in);
        if (hasDepartmentController(scanner)) {
            view.printMessageWithoutLn("Enter name of type of goods[shoes, clothes, appliances]>>");
            String typeOfGoods = scanner.nextLine();
            view.printMessageWithoutLn("Enter the number of goods supplied. ");
            int positive = getPositive(scanner);
            if (model.addGoodsForDepartment(DataSource.getGoods(typeOfGoods, positive))) {
                view.printMessage("Goods added");
            } else
                view.printMessage(View.WRONG_INPUT_INT_DATA);
        } else {
            view.printMessage("No department");
        }
    }

    private int getPositive(Scanner sc) {
        sc = new Scanner(System.in);
        int input;
        while (true) {
            view.printMessageWithoutLn("Enter a positive number >>");
            if (!sc.hasNextInt()) {
                view.printMessage(view.WRONG_INPUT_INT_DATA);
                sc.next();
                continue;
            }
            input = sc.nextInt();
            if (input <= 0) {
                view.printMessage(view.WRONG_INPUT_INT_DATA);
                continue;
            }
            return input;
        }
    }

    private void deleteDep(Scanner scanner) {
        scanner = new Scanner(System.in);
        view.printMessageWithoutLn("Enter name of department>>");
        String s = scanner.nextLine();
        if (model.eliminateTheDepartment(s)) {
            view.printMessage("Department removed");
        } else {
            view.printMessage("There is no such department");
        }
    }

    private void createDepartments(Scanner scanner) {
        scanner = new Scanner(System.in);
        view.printMessageWithoutLn("Name of department >>");
        String name = scanner.nextLine();
        view.printMessageWithoutLn("Type of goods >>");
        String type = scanner.nextLine();
        view.printMessageWithoutLn("Location. ");
        int location = getPositive(scanner);
        if (model.alreadyExists(location)) {
            view.printMessage("This location belongs to another department!");
            return;
        }
        view.printMessageWithoutLn("Enter the number of services divided by \";\" symbol >>");
        String services = scanner.nextLine();
        List<String> listOfServ = new ArrayList<>(Arrays.asList(services.split(";")));
        if (model.addNewDepartment(name, type, location, listOfServ)) {
            view.printMessage("Department added!");
        } else {
            view.printMessage("Department exists");
        }
    }

    private void getDepartments() {
        List listOfDepartments = model.getListOfDepartments();
        if (listOfDepartments.size() == 0) {
            view.printMessage("No departments");
        } else
            view.printListOfDepartments("All departments", listOfDepartments);
    }
    public static void main(String[] args) {new Controller(new Shop(), new ShopView()).run();}
}
