package practice7.task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {
    public void run() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = UnaryOperation.class;
        Constructor<?> constructor = clazz.getConstructor();
        UnaryOperation un= (UnaryOperation)constructor.newInstance();
        System.out.println(un);
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("set")){
                method.invoke(un, 0.0);
                System.out.println(un);
            }
            if(method.getName().startsWith("inc")){
                method.invoke(un);
                System.out.println(un);
            }
        }
    }
}
