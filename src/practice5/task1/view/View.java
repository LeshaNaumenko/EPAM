package practice5.task1.view;

import java.util.Collection;

public class View {


    public void printMessage(String menu) {
        System.out.println(menu);
    }

    public void printList(Collection allRecords) {
        for (Object record : allRecords) {
            System.out.println(record);
        }
    }
}
