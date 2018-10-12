package practice1.task1;

import practice1.task1.сontroller.Controller;
import practice1.task1.model.Model;
import practice1.task1.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller;
        for (int i = 0; i <5 ; i++) {
         controller = new Controller(new View(), new Model());

        controller.calculate();
        }
    }
}
