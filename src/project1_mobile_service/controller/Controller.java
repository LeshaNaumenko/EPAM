package project1_mobile_service.controller;

import project1_mobile_service.view.*;
import project1_mobile_service.data.DataSource;
import project1_mobile_service.model.comparator.sortBySubscriptFeeComparator;
import project1_mobile_service.model.entity.*;
import project1_mobile_service.service.Service;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private ViewTariff viewTariff;
    private Service service;
    private InputUtility utility;

    public Controller(Company model, ViewTariff viewTariff, InputUtility utility) {
        service = new Service(DataSource.getTariff(model));
        DataSource.getRandomClients(model);
        this.viewTariff = viewTariff;
        this.utility = utility;
        this.utility.setViewTariff(viewTariff);
    }

    public void run() {
        while (true) {
            viewTariff.printMenu();
            int input = utility.inputNumber("");
            switch (input) {
                case 1:
                    viewTariff.printListOfTariffs(service.getListOfTariffs());
                    break;
                case 2:
                    viewTariff.printResult(ConstantsMessage.NUMBER_OF_CLIENTS,service.getTotalNumberOfClients());
                    break;
                case 3:
                    viewTariff.printListOfTariffs(service.sortTariff(new sortBySubscriptFeeComparator()));
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
                case 8:
                    copy = Service.haveSMS(copy);
                    break;
                case 9:
                    copy = Service.haveNoSMS(copy);
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
