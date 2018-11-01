package project1_mobile_service.service;

import project1_mobile_service.model.entity.Company;

import java.util.*;

/**
 * {@code Service} class provides methods for performing operations with one or
 * more models as well as static methods for filtering the list of tariffs.
 *
 * @author Alex Naumenko
 * @see Company
 * @version 1.0
 */

public class Service {

    /**
     * Company instance.
     */
    private Company model;

    /**
     * Constructs a new Service object with a particular company instance.
     * @param model
     */
    public Service(Company model) {
        this.model = model;
    }

    /**
     * Returns list of tariffs.
     * @return tariffList
     */
    public List<Company.Tariff> getListOfTariffs() {
        return model.getTariffList();
    }

    /**
     * Returns the number of total clients.
     * @return sum
     */
    public int getTotalNumberOfClients() {
        return model.getTotalNumberOfClients();
    }

    /**
     * Sorted tariffs on the company by parameter provided
     * @param comparator {@code Comparator<Company.Tariff>}
     * @return
     */
    public List<Company.Tariff> sortTariff(Comparator<Company.Tariff> comparator) {
        return model.sort(comparator);
    }

    //Methods for searching*********************************

    /**
     * Selects tariff by name
     * @param tempList
     * @param name
     * @return list of selected tariffs
     */
    public static List<Company.Tariff> findByName(List<Company.Tariff> tempList, String name) {
        List<Company.Tariff> temp = new ArrayList<>();

        for (Company.Tariff tariff : tempList) {
            if (name.equals(tariff.getName())) {
                temp.add(tariff);
            }
        }
        return temp;
    }

    /**
     * Selects tariffs excluding the name
     * @param tempList
     * @param name
     * @return list of selected tariffs
     */
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

    /**
     * Selects tariffs that are equal to the one specified subscription fee in the parameters.
     * @param copy
     * @param input
     * @return list of selected tariffs
     */
    public static List<Company.Tariff> findBySubscriptionFee(List<Company.Tariff> copy, int input) {
        List<Company.Tariff> temp = new ArrayList<>();

        for (Company.Tariff tariff : copy) {
            if (input == tariff.getSubscriptionFee()) {
                temp.add(tariff);
            }
        }
        return temp;
    }


    /**
     * Selects tariffs that are higher than specified subscription fee in parameters.
     * @param copy
     * @param input
     * @return list of selected tariffs
     */
    public static List<Company.Tariff> moreThanSpecifiedSubscriptionFee(List<Company.Tariff> copy, int input) {
        List<Company.Tariff> temp = new ArrayList<>();

        for (Company.Tariff tariff : copy) {
            if (input <= tariff.getSubscriptionFee()) {
                temp.add(tariff);
            }
        }
        return temp;
    }

    /**
     * Selects tariffs that are lower than specified subscription fee in parameters.
     * @param copy
     * @param input
     * @return list of selected tariffs
     */
    public static List<Company.Tariff> lessThanSpecifiedSubscriptionFee(List<Company.Tariff> copy, int input) {
        List<Company.Tariff> temp = new ArrayList<>();

        for (Company.Tariff tariff : copy) {
            if (input >= tariff.getSubscriptionFee()) {
                temp.add(tariff);
            }
        }
        return temp;
    }

    /**
     * Selects tariffs that have internet
     * @param copy
     * @return list of selected tariffs
     */
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
    /**
     * Selects tariffs that have no internet
     * @param copy
     * @return list of selected tariffs
     */
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