package project1_mobile_service.controller;

import project1_mobile_service.view.*;
import project1_mobile_service.data.DataSource;
import project1_mobile_service.model.comparator.SortBySubscriptFeeComparator;
import project1_mobile_service.model.entity.*;
import project1_mobile_service.service.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code Controller} is part of the MVC pattern. The controller, accepts input and
 * converts it to commands for the {@code Company} or {@code ViewTariff}.
 *
 * @author Alex Naumenko
 * @see ViewTariff
 * @see Service
 * @see InputUtility
 * @version 1.0
 */

public class Controller {
    /**
     * View object.
     */
    private ViewTariff viewTariff;
    /**
     * Service object.
     */
    private Service service;

    /**
     * Input utility object.
     */

    private InputUtility utility;

    /**
     * Constructs a new Controller object with model, viewTariff and utility.
     */
    public Controller(Company model, ViewTariff viewTariff, InputUtility utility) {
        service = new Service(DataSource.getTariff(model));
        DataSource.getRandomClients(model);
        this.viewTariff = viewTariff;
        this.utility = utility;
        this.utility.setViewTariff(viewTariff);
    }

    /**
     * Method to start the controller
     */
    public void run() {
        while (true) {
            viewTariff.printMenu();
            int input = utility.inputNumber("");
            switch (input) {
                case 1:
                    viewTariff.printListOfTariffs(service.getListOfTariffs());
                    break;
                case 2:
                    viewTariff.printResult(ConstantsMessage.NUMBER_OF_CLIENTS, service.getTotalNumberOfClients());
                    break;
                case 3:
                    viewTariff.printListOfTariffs(service.sortTariff(new SortBySubscriptFeeComparator()));
                    break;
                case 4:
                    getListOfCertainParameters();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    viewTariff.printMessage(ConstantsMessage.WRONG_INPUT_INT_DATA + "\n");
                    break;
            }
        }
    }

    /**
     * Method to filter tariffs
     */
    private void getListOfCertainParameters() {
        List<Company.Tariff> copy = new ArrayList<>(service.getListOfTariffs());
        while (true) {
            viewTariff.printFindMenu();
            int inputNumber = utility.inputNumber("\t\t");
            switch (inputNumber) {
                case 1:
                    String line = utility.getLine();
                    copy = Service.findByName(copy, line);
                    break;
                case 2:
                    String line1 = utility.getLine();
                    copy = Service.findExcludingName(copy, line1);
                    break;
                case 3:
                    int input = utility.inputNumber("=fee\t");
                    copy = Service.findBySubscriptionFee(copy, input);
                    break;
                case 4:
                    int input1 = utility.inputNumber(">fee\t");
                    copy = Service.moreThanSpecifiedSubscriptionFee(copy, input1);
                    break;
                case 5:
                    int input2 = utility.inputNumber("<fee\t");
                    copy = Service.lessThanSpecifiedSubscriptionFee(copy, input2);
                    break;
                case 6:
                    copy = Service.haveInternet(copy);
                    break;
                case 7:
                    copy = Service.haveNoInternet(copy);
                    break;
                case 0:
                    return;
                default:
                    continue;
            }
            if (!hasEmptyListOfTariff(copy)) {
                return;
            }
        }
    }

    /**
     * Method of checking the existence of tariffs
     * @param list
     * @return
     */
    private boolean hasEmptyListOfTariff(List<Company.Tariff> list) {
        if (list.size() == 0) {
            viewTariff.printMessage(ConstantsMessage.NO_TARIFF);
            return false;
        } else {
            viewTariff.printMessage(ConstantsMessage.RESULT);
            viewTariff.printListOfTariffs(list);
            return true;
        }
    }
}
