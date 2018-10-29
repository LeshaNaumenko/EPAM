package practice5.task1.view;

import java.util.Collection;

public class View {


    public void printMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public void printList(Collection allRecords) {
        for (Object record : allRecords) {
            System.out.println(record);
        }
    }
}
