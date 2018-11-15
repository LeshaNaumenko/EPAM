package practice7.task1;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Runner {
    public void run() throws NoSuchFieldException, IllegalAccessException {

        String string = "Hello";

        /*Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();*/
        System.out.println("string = " + string);
        Class<?> aClass = String.class;
        Field declaredField = aClass.getDeclaredField("value");
        declaredField.setAccessible(true);
        declaredField.set(string, "new value".toCharArray());
        System.out.println("New string = " + string);
    }
}
