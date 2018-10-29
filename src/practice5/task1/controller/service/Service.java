package practice5.task1.controller.service;

import practice5.task1.model.Address;
import practice5.task1.model.ClassRegister;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

public class Service {

    private ClassRegister classRegister;

    public ClassRegister getClassRegister() {
        return classRegister;
    }

    public void setClassRegister(ClassRegister classRegister) {
        this.classRegister = classRegister;
    }

    public boolean addAll(String[] checkFullName,int[] calendar, String phone, String[] address ) {

         return classRegister.addRecord(checkFullName[0], checkFullName[1], checkFullName[2], new GregorianCalendar(calendar[0],calendar[1],calendar[2]), phone, new Address(address[0],address[1], address[2]));
    }

    public Collection getAllRecords() {
        return classRegister.getRecordList();
    }
}
