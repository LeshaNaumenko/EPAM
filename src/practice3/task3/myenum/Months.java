package practice3.task3.myenum;

import java.lang.reflect.Field;

public final class Months extends MyEnum {

    public static final Months JANUARY = new Months("JANUARY", "description");
    public static final Months FEBRUARY = new Months("FEBRUARY", "description");
    public static final Months MARCH = new Months("MARCH", "description");
    public static final Months APRIL = new Months("APRIL", "description");
    public static final Months MAY = new Months("MAY", "description");
    public static final Months JUNE = new Months("JUNE", "description");
    public static final Months JULY = new Months("JULY", "description");
    public static final Months AUGUST = new Months("AUGUST", "description");
    public static final Months SEPTEMBER = new Months("SEPTEMBER", "description");
    public static final Months OCTOBER = new Months("OCTOBER", "description");
    public static final Months NOVEMBER = new Months("NOVEMBER", "description");
    public static final Months DECEMBER = new Months("DECEMBER", "description");

    String description;

    public Months(String input, String description) {
        super(input);
        this.description = description;
        states.put(index, this);
    }
/*
    public static void values() {
        Field[] declaredFields = Months.class.getDeclaredFields();

        Class<MyEnum> aClass = MyEnum.class;
*//*
        if (aClass.isAssignableFrom(declaredFields[this.index].getType())) {
            //System.out.println("true "+declaredField.getType()+" = "+aClass);
            return declaredFields[this.index].getName();


        } *//*

        //
        Months[] months = new Months[declaredFields.length];
        int counter =0;
        for (int i = 0; i < declaredFields.length; i++) {
            if (aClass.isAssignableFrom(declaredFields[i].getType())){
            }
        }

    }*/
}
