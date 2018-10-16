package practice1.task5_matrix.controller;

import practice1.task5_matrix.model.Model;
import practice1.task5_matrix.view.View;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run(){
        model.setMyArray(DataSource.getDate());
        view.printMatrix(model.getMyArray());
        view.printMatrix(model.turnedOn90DegreesToTheLeft());
    }
}

class DataSource {

    public static int[][] getDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of the matrix:");
        int input = scanner.nextInt();
        int[][] myArray = new int[input][input];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                myArray[i][j] = i;
            }
        }
        return myArray;
    }
}
