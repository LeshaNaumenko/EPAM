package practice1.task2;

import practice1.task2.controller.Controller;
import practice1.task2.model.Model;
import practice1.task2.view.View;

public class Main {
    public static void main(String[] args) {
        new Controller(new Model(), new View()).run();
    }
}
