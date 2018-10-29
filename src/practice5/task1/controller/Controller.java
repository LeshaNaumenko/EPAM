package practice5.task1.controller;

import practice5.task1.controller.service.Service;
import practice5.task1.model.Address;
import practice5.task1.model.ClassRegister;
import practice5.task1.view.StudentMenu;
import practice5.task1.view.Validator;
import practice5.task1.view.View;
import project1_mobile_service.view.ConstantsMessage;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Controller {

    Service service = new Service();
    Validator validator = new Validator();
    View view = new View();

    {
        validator.setView(view);
        service.setClassRegister(new ClassRegister());
    }

    public void run(){

        while (true){
            view.printMessage(StudentMenu.MENU);

            int posNumber = validator.getPosNumber();

            switch (posNumber){
                case 1:
                    view.printList(service.getAllRecords());
                    break;
                case 2:
                    String[] strings = validator.checkFullName();
                    int[] date = validator.checkDate();
                    String phone = validator.checkNumber();
                    String[] address = validator.checkAddress();
                    if (service.addAll(strings, date,
                            phone, address)){
                        view.printMessage(ConstantsMessage.SUCCESSFULLY);
                    }else
                        view.printMessage(ConstantsMessage.NAME_MUST_NOT_MATCH);
                    break;
                case 0:
                    System.exit(0);
                default:
                    view.printMessage(ConstantsMessage.WRONG_INPUT_INT_DATA);
            }
        }
    }

    public static void main(String[] args) {
        new Controller().run();
    }
}
