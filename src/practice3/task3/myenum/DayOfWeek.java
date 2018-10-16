package practice3.task3.myenum;

public final class DayOfWeek extends myEnum {


    public static myEnum myEum = new DayOfWeek("MONDAY");
    public static myEnum myEum2 = new DayOfWeek("FRIDAY");
    public static myEnum myEum3 = new DayOfWeek("SUNDAY");


    private DayOfWeek(String input) {
        super(input);
    }


}
