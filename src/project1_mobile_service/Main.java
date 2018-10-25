package project1_mobile_service;

import project1_mobile_service.controller.Controller;
import project1_mobile_service.model.entity.Lifecell;
import project1_mobile_service.view.*;

public class Main {
    public static void main(String[] args) {
        new Controller(new Lifecell(), new ViewTariff(), new InputUtility()).run();
    }
}
