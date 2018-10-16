package practice3.task2.view;

import practice3.task2.model.entity.Goods;

import java.util.List;
import java.util.Set;

public class ShopView {
    public static final String WRONG_INPUT_INT_DATA = "Wrong input. Repeat please.";

    public void printMessage(String s) {
        System.out.println(s);
        System.out.println();
    }

    public void printListOfDepartments(String message, List listOfDepartments) {
        System.out.println(message);
        for (Object listOfDepartment : listOfDepartments) {
            System.out.println(listOfDepartment);
        }
        System.out.println();
    }

    public void printMessageWithoutLn(String s) {
        System.out.print(s);
    }

    public void printListOfGoods(List<Goods> goodsOfDepartment) {
        goodsOfDepartment.forEach(System.out::println);
        System.out.println();
    }

    public void printListOfLocations(Set<Integer> listOfLocation) {
        listOfLocation.forEach(System.out::println);
        System.out.println();
    }
}
