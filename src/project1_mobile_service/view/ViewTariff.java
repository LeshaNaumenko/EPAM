package project1_mobile_service.view;

import project1_mobile_service.model.entity.Company;

import java.util.List;

public class ViewTariff {

    public void printListOfTariffs(List<Company.Tariff> list){

        for (Company.Tariff tariff : list) {
            System.out.println(tariff);
        }
        System.out.println();
    }
    public void printMessage(String message){
        System.out.println(message);
    }


    public void printMessageWithoutLn(String message) {
        System.out.print(message);

    }

    public void printResult(String message,int totalNumberOfClients) {
        System.out.println(totalNumberOfClients);
    }

    public void printMenu() {
        System.out.println( Menu.LIST+Menu.TOTAL_NUMBER_OF_CLIENT+Menu.SORT_BY_FEE+Menu.FIND_TARIFF+Menu.EXIT);
    }

    public void printFindMenu() {
        System.out.println( FindMenu.BY_NAME+FindMenu.DELETE_NAME+FindMenu.FEE+FindMenu.MORE_FEE+FindMenu.LESS_FEE
                +FindMenu.HAS_INTERNET+FindMenu.HAS_NO_INTERNET+FindMenu.HAS_SMS+FindMenu.HAS_NO_SMS+FindMenu.BACK_TO_MENU);
    }
}
