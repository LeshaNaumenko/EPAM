package practice3.task3.myenum;


import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class MyEnum implements Comparable {

    public static void main(String[] args) {
        Months.values();
    }

    protected static Map<Integer, MyEnum> states = new LinkedHashMap<>();
    private static int counter;
    private final String name;
    protected final int index = counter++;;

    protected MyEnum(String input) {
        name = input;
    }

    public static Collection<MyEnum> values(){
        return states.values();
    }

    public final String name() {
        return name;
    }

    public final int ordinal() {
        return index;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public final boolean equals(Object other) {
        return this==other;
    }

/*    public static MyEnum[] values(){
        return null;
    }*/
    public static void getFields() {
        /*String callerClassName = new Exception().getStackTrace()[1].getClassName();
        String calleeClassName = new Exception().getStackTrace()[0].getClassName();
        System.out.println(Thread.currentThread().getStackTrace()[0].getClassName());
        System.out.println(calleeClassName);
        getFields();
        Class<MyEnum> aClass = MyEnum.class;
        Class<?> aClass1 = null;
        try {
            aClass1 = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass.isAssignableFrom(aClass1));
        System.out.println();
        System.out.println(aClass1);
        System.out.println(aClass);*/

        /*Field[] declaredFields = this.getClass().getDeclaredFields();
        Class<MyEnum> aClass = MyEnum.class;

        if (aClass.isAssignableFrom(declaredFields[this.index].getType())) {
            //System.out.println("true "+declaredField.getType()+" = "+aClass);
            return declaredFields[this.index].getName();


        } else
            return "**FALSE**";
        //System.out.println("false "+declaredField.getType()+" != "+aClass);
*/

    }
}
