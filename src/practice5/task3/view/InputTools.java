package practice5.task3.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputTools {

    static Scanner scanner= new Scanner(System.in);
    View view;

    public InputTools(View view) {
        this.view = view;
    }

    public String getLine(){
        scanner = new Scanner(System.in);
        Pattern compile = Pattern.compile("([A-Za-z]+\\s*)*");
        while (true) {
            view.printMessage(ConstantsMessageTranslator.SENTENCE);
            String temp = scanner.nextLine();
            Matcher matcher = compile.matcher(temp);
            if (matcher.find()) {
                return temp;
            }else {
                view.printMessage(ConstantsMessageTranslator.WRONG_INPUT_INT_DATA);
            }
        }
    }
    public int getPosNumber() {
        scanner = new Scanner(System.in);
        int input;

        Pattern compile = Pattern.compile("^[012]$");
        while (true) {
            view.printMessage(ConstantsMessageTranslator.POSITIVE);
            String temp = scanner.nextLine();
            Matcher matcher = compile.matcher(temp);
            if (matcher.find()) {
                return Integer.valueOf(temp);
            }
            else
                view.printMessage(ConstantsMessageTranslator.WRONG_INPUT_INT_DATA);
        }
    }

    public String[] checkInputWords() {
        scanner = new Scanner(System.in);
        String temp;
        String[] split = null;
        String s = "^[A-Za-z]+\\s*-\\s*[А-Яа-я]+$";
        Pattern p = Pattern.compile(s);
        while (!(temp = scanner.nextLine()).equals("n")) {
            Matcher m = p.matcher(temp);
            if (m.find()) {
                split = temp.split("[-]");
                split[0] = split[0].trim();
                split[1] = split[1].trim();
                break;
            }
            view.printMessage(ConstantsMessageTranslator.WRONG_INPUT_INT_DATA);
        }
        return split;
    }

    public static void main(String[] args) {
        InputTools inputTools = new InputTools(new View());
        String[] strings = inputTools.checkInputWords();
        System.out.println(strings[0]);
        System.out.println(strings[1]);
    }
}
