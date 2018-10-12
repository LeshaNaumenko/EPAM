package practice1.task1.view;

public class View {

    public static final String WRONG_INPUT_INT_DATA="Wrong input. Repeat please.";
    public static final String CONDITION ="Convert to all number systems      -  0\n"+
            "Convert to binary(base 2) system   -  2\n" +
            "Convert to octal (base 8)          -  8\n" +
            "Convert to hexadecimal(base 16) system - 16\n>>";
    public static final String INPUT_INT_DATA= "Enter a positive integer:\n>>";
    public static final String OUT_FOR_ALL = "For %d : \n\t**Base-2 = %s\n\t**Base-8 = %s\n\t**Base-16 = %s\n";
    public static final String OUT_ONLY_FOR_ONE = "For %d : \n\t**%s = %s\n";
    public void printMessage(String message){
        System.out.println(message);
    }
    public void printResult(String message, int value, String base2,String base8,String base16){
        System.out.printf(message,value, base2,base8,base16);
    }
    public void printResult(String message, int value, String baseNumber, String result){
        System.out.printf(message,value, baseNumber, result);
    }

/*    public static void main(String[] args) {
        new view().printResult(OUT_FOR_ALL,  NumberSystem.BASE2.getNumb(),"dsf", "sfdsf", "dfdfd");
        new view().printResult(OUT_ONLY_FOR_ONE, 10 , NumberSystem.BASE2.getSys(), "sfdsf");
    }*/
}
