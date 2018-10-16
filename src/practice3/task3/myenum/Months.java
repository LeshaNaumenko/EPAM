package practice3.task3.myenum;

public final class Months extends myEnum {

    public static Months s1 = new Months("JANUARY", "description");
    public static Months s2 = new Months("FEBRUARY", "description");
    public static Months s3 = new Months("MARCH", "description");
    public static Months s4 = new Months("APRIL", "description");
    public static Months s5 = new Months("MAY", "description");
    public static Months s6 = new Months("JUNE", "description");
    public static Months s7 = new Months("JULY", "description");
    public static Months s8 = new Months("AUGUST", "description");
    public static Months s9 = new Months("SEPTEMBER", "description");
    public static Months s10 = new Months("OCTOBER", "description");
    public static Months s11 = new Months("NOVEMBER", "description");
    public static Months s12 = new Months("DECEMBER", "description");

    String description;

    public Months(String input, String description) {
        super(input);
        this.description = description;
    }
}
