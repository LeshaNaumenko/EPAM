package project1_mobile_service.view;

import project1_mobile_service.model.entity.Company;

import java.util.List;

/**
 * The ViewTariff is part of the MVC pattern.
 * The view means presentation of the model in a particular format
 *
 * @author Alex Naumenko
 * @version 1.0
 */


public class ViewTariff {

    /**
     * Outputs list of tariffs.
     * @param list
     */
    public void printListOfTariffs(List<Company.Tariff> list){

        for (Company.Tariff tariff : list) {
            System.out.println(tariff);
        }
        System.out.println();
    }

    /**
     * Output message to console.
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Output message to console.
     * @param message
     */

    public void printMessageWithoutLn(String message) {
        System.out.print(message);
    }

    /**
     * Outputs some result.
     * @param message
     * @param totalNumberOfClients
     */

    public void printResult(String message,int totalNumberOfClients) {
        System.out.println(totalNumberOfClients);
    }

    /**
     * Outputs menu.
     */

    public void printMenu() {
        System.out.println( Menu.LIST+Menu.TOTAL_NUMBER_OF_CLIENT+Menu.SORT_BY_FEE+Menu.FIND_TARIFF+Menu.EXIT);
    }

    /**
     * Outputs find menu.
     */

    public void printFindMenu() {
        System.out.println( FindMenu.BY_NAME+FindMenu.DELETE_NAME+FindMenu.FEE+FindMenu.MORE_FEE+FindMenu.LESS_FEE
                +FindMenu.HAS_INTERNET+FindMenu.HAS_NO_INTERNET+FindMenu.BACK_TO_MENU);
    }
}
