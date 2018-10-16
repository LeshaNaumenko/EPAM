package practice3.task2;

import practice3.task2.controller.Controller;
import practice3.task2.model.Shop;
import practice3.task2.view.ShopView;

public class Main {
    public static void main(String[] args) {new Controller(new Shop(), new ShopView()).run();}

}
