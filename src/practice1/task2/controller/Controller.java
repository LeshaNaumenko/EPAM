package practice1.task2.controller;

import practice1.task2.model.Model;
import practice1.task2.view.View;

import java.util.Scanner;

public class Controller {

    private Model m;
    private View v;

    public Controller(Model m, View v) {
        this.m = m;
        this.v = v;
    }

    public void run(){

        String s = m.calculatePerfect(DataSource.getData());
        if (!s.equals("")) {
            v.printResult(m.getPerfectNumber());
        }else {
            v.printMessage("No perfect numbers");
        }
    }
}

class DataSource{
    public static int getData(){
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Enter a positive number");
            System.out.print(">>");
            if (!scanner.hasNextInt()) {
                System.out.println("**Repeat please**");
                scanner.next();
                continue;
            }
            input = scanner.nextInt();

            if (input <= 0) {
                System.out.println("**Repeat please**");
                continue;
            }
            break;
        }
        return input;
    }
}
