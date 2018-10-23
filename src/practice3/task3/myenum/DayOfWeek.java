package practice3.task3.myenum;

public  final class DayOfWeek extends MyEnum {


    public static final DayOfWeek myEum = new DayOfWeek("MONDAY");
    public static final DayOfWeek myEum2 = new DayOfWeek("FRIDAY");
    public static final DayOfWeek myEum3 = new DayOfWeek("SUNDAY");


    private DayOfWeek(String input) {
        super(input);
    }


}
