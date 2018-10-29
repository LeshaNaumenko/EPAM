package practice5.task1.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    Scanner scanner;

    View view;

    public void setView(View view) {
        this.view = view;
    }

    public int getPosNumber() {
        scanner = new Scanner(System.in);
        int input;

        Pattern compile = Pattern.compile("^[0-9]$");
        while (true) {
            view.printMessage(ConstantMessage.POSITIVE);
            String temp = scanner.nextLine();
            Matcher matcher = compile.matcher(temp);
            if (matcher.find()) {
                return Integer.valueOf(temp);
            }
            else
                view.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA);
        }
    }

    public String[] checkFullName() {
        scanner = new Scanner(System.in);
        String temp;
            view.printMessage(ConstantMessage.ENTER_NAME);
        String s = "([A-Z][a-z]+\\s*){3}";
        Pattern p = Pattern.compile(s);
        String[] split = null;
        while (!(temp = scanner.nextLine()).equals("n")) {
            Matcher m = p.matcher(temp);
            if (m.find()) {
                split = temp.split("\\s+");
                break;
            }
                view.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA);
        }
        return split;
    }

    public static void main(String[] args) {

        new Validator().checkFullName();
    }

    public int[] checkDate() {
        int[] date = new int[3];
        scanner = new Scanner(System.in);
        view.printMessage(ConstantMessage.ENTER_DATE);
        String s = "(\\d{4})\\s(0\\d|1[012])\\s([0-2]\\d|3[01])";
        Pattern compile = Pattern.compile(s);
        String temp;
        while (!(temp=scanner.nextLine()).equals("n")){
            Matcher matcher = compile.matcher(temp);
            if (matcher.find()){
                String[] split = temp.split("\\s+");
                date[0] = Integer.valueOf(split[0]);
                date[1] = Integer.valueOf(split[1]);
                date[2] = Integer.valueOf(split[2]);
                break;
            }
                view.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA);
        }
        return date;
    }

    public String checkNumber() {
        view.printMessage(ConstantMessage.ENTER_NUMBER);
        String temp;
//        Pattern compile = Pattern.compile(  "\\+[1-9](\\d{,2})\\(\\d{2}\\)(\\d{2}-){2}\\d{3}");
        Pattern compile = Pattern.compile(  "\\+[1-9]\\d{2}\\(\\d{2}\\)(\\d{2}-){2}\\d{3}");
//        Pattern compile = Pattern.compile("\\+[1-9]  (\\d{2})    \\([0-9]{2}\\)   ([0-9]{2}-){2}([0-9]{3})");
        while (!(temp=scanner.nextLine()).equals("n")){
            if (compile.matcher(temp).find()){
                break;
            }
            view.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA);
        }
        return temp;
    }

    public String[] checkAddress() {
        view.printMessage(ConstantMessage.ENTER_ADDRESS);
        String temp;
        Pattern compile = Pattern.compile("[а-яА-Я]+[,.]?\\s*(ул|пер)[.,]\\s*[а-яА-Я\\s]+,\\s*(\\d+,)?\\s*(д|кв)\\.\\s*\\d+$");
        while (!(temp=scanner.nextLine()).equals("n")){
            if (compile.matcher(temp).find()){
                break;
            }
            view.printMessage(ConstantMessage.WRONG_INPUT_INT_DATA);
        }
        return temp.split("\\s+");
    }
}
