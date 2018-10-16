package practice1.task5_matrix;

import practice1.task5_matrix.controller.Controller;
import practice1.task5_matrix.model.Model;
import practice1.task5_matrix.view.View;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Controller(new Model(), new View()).run();

    }



}
