package project1_mobile_service.service;

import project1_mobile_service.model.entity.Company;

import java.util.*;

public class Service {

    private Company model;

    public Service(Company model) {
        this.model = model;
    }

    public List<Company.Tariff> getListOfTariffs() {
        return model.getTariffList();
    }

    public int getTotalNumberOfClients() {
        return model.getTotalNumberOfClients();
    }

    public List<Company.Tariff> sortTariff(Comparator<Company.Tariff> comparator) {
        return model.sort(comparator);
    }

    //Methods for searching*********************************

    public static List<Company.Tariff> findByName(List<Company.Tariff> tempList, String name) {
        List<Company.Tariff> temp = new ArrayList<>();

        for (Company.Tariff tariff : tempList) {
            if (name.equals(tariff.getName())) {
                temp.add(tariff);
            }
        }
        return temp;
    }

    public static List<Company.Tariff> findExcludingName(List<Company.Tariff> tempList, String name) {
        Iterator<Company.Tariff> iterator = tempList.iterator();

        while (iterator.hasNext()) {
            Company.Tariff next = iterator.next();
            if (name.equals(next.getName())) {
                iterator.remove();
            }
        }
        return tempList;
    }

    public static List<Company.Tariff> findBySubscriptionFee(List<Company.Tariff> copy, int input) {
        List<Company.Tariff> temp = new ArrayList<>();

        for (Company.Tariff tariff : copy) {
            if (input == tariff.getSubscriptionFee()) {
                temp.add(tariff);
            }
        }
        return temp;
    }

    public static List<Company.Tariff> moreThanSpecifiedSubscriptionFee(List<Company.Tariff> copy, int input1) {
        List<Company.Tariff> temp = new ArrayList<>();

        for (Company.Tariff tariff : copy) {
            if (input1 <= tariff.getSubscriptionFee()) {
                temp.add(tariff);
            }
        }
        return temp;
    }

    public static List<Company.Tariff> lessThanSpecifiedSubscriptionFee(List<Company.Tariff> copy, int input2) {
        List<Company.Tariff> temp = new ArrayList<>();

        for (Company.Tariff tariff : copy) {
            if (input2 >= tariff.getSubscriptionFee()) {
                temp.add(tariff);
            }
        }
        return temp;
    }

    public static List<Company.Tariff> haveInternet(List<Company.Tariff> copy) {
        Iterator<Company.Tariff> iterator = copy.iterator();

        while (iterator.hasNext()) {
            Company.Tariff next = iterator.next();
            if (next instanceof Company.TariffWithoutInternet) {
                iterator.remove();
            }
        }
        return copy;
    }

    public static List<Company.Tariff> haveNoInternet(List<Company.Tariff> copy) {
        Iterator<Company.Tariff> iterator = copy.iterator();

        while (iterator.hasNext()) {
            Company.Tariff next = iterator.next();
            if (next instanceof Company.TariffInternet) {
                iterator.remove();
            }
        }
        return copy;
    }

   /* public static List<Company.Tariff> haveSMS(List<Company.Tariff> copy) {
        Iterator<Company.Tariff> iterator = copy.iterator();

        while (iterator.hasNext()){
            Company.Tariff next = iterator.next();
            if (next.getSms() == null) {
                iterator.remove();
            }
        }
        return copy;
    }

    public static List<Company.Tariff> haveNoSMS(List<Company.Tariff> copy) {
        Iterator<Company.Tariff> iterator = copy.iterator();

        while (iterator.hasNext()){
            Company.Tariff next = iterator.next();
            if (next.getSms()!= null) {
                iterator.remove();
            }
        }
        return copy;
    }*/
    //End of methods for searching**************************
}