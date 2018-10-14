package practice1.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            System.out.println("Enter a positive number");
            System.out.print(">>");
            if (!scanner.hasNextInt()) {
                System.out.println("**Repeat please**");
                scanner.next();
                continue;
            }
            input = scanner.nextInt();

            if (input <= 0 || input > 9) {
                System.out.println("**Repeat please**");
                continue;
            }
            break;
        }
        for (int i = input, leng = input, other = input; i > 0; i--, other--, leng++) {
            int temp = 0;
            for (int j = 1; j <= leng; j++) {
                if (j < other)
                    System.out.print(" ");
                else if (j <= input)
                    System.out.print(++temp);
                else System.out.print(--temp);
            }
            System.out.println();
        }



        /*   COMPACT FORM
        for (int i= input,leng = input,other= input,temp = 0; i >0; i--,other--,leng++, temp=0) {
            //int temp = 0;
            for (int j = 1; j <=leng; j++) {
                System.out.print((j<other)?" ":(j<=input)?++temp:--temp);
            }
            System.out.println();
        }
*/
    }
}
