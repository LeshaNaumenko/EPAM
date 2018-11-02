package practice5.task1.controller;

import practice5.task1.controller.service.Service;
import practice5.task1.model.ClassRegister;
import practice5.task1.view.StudentMenu;
import practice5.task1.view.Validator;
import practice5.task1.view.View;
import practice5.task1.view.ConstantMessage;
import java.util.Collection;

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
                    hasListOfRecord(service.getAllRecords());
                    break;
                case 2:
                    String[] strings = validator.checkFullName();
                    int[] date = validator.checkDate();
                    String phone = validator.checkNumber();
                    String[] address = validator.checkAddress();
                    if (service.addAll(strings, date,
                            phone, address)){
                        view.printMessage(ConstantMessage.SUCCESSFULLY);
                    }else
                        view.printMessage(ConstantMessage.NAME_MUST_NOT_MATCH);
                    break;
                case 0:
                    System.exit(0);
                default:
                    view.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA);
            }
        }
    }

    private void hasListOfRecord(Collection allRecords) {
        if (!allRecords.isEmpty()){
            view.printList(allRecords);
        }else
            view.printMessage(ConstantMessage.NO_RECORDS);
    }

    public static void main(String[] args) {
        new Controller().run();
    }
}
