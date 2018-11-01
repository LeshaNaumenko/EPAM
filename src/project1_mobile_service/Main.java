package project1_mobile_service;

import project1_mobile_service.controller.Controller;
import project1_mobile_service.model.entity.Company;
import project1_mobile_service.view.*;

/**
 * Main class
 *
 * @author Alex Naumenko
 * @see Company
 * @see ViewTariff
 * @see InputUtility
 * @version 1.0
 */

public class Main {

    /**
     * Starts the program
     * @param args
     */
    public static void main(String[] args) {
        new Controller(new Company(), new ViewTariff(), new InputUtility()).run();
    }
}
