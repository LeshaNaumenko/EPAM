package practice3.task1.view;

import practice3.task1.model.entity.Toy;

public class ViewToy {

    public static final String NO_TOY ="No toy";
    public static final String TOTAL_VALUE_OF_TOYS = "Total value of toys:";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input. Repeat please.";


    public void printList(String message, Toy[] array){
        System.out.println(message);
        for (Toy toy : array) {
            System.out.println(toy);
        }
        System.out.println();
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void printResult(String message, double result) {
        System.out.print(message + " = ");
        System.out.println(result + "\n");
    }
}
