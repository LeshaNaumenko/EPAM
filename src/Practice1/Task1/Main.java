package Practice1.Task1;

import Practice1.Task1.Controller.Controller;
import Practice1.Task1.Model.Model;
import Practice1.Task1.View.View;

public class Main {
    public static void main(String[] args) {
        Controller controller;
        for (int i = 0; i <5 ; i++) {
         controller = new Controller(new View(), new Model());

        controller.calculate();
        }
    }
}
