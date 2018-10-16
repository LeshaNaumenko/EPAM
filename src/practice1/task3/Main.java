package practice1.task3;

import practice1.task3.controller.Controller;
import practice1.task3.model.Model;
import practice1.task3.view.View;

public class Main {
    public static void main(String[] args) {
        new Controller(new Model(), new View()).run();
    }
}
