package Practice1.Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        /*   COMPACT FORM
        for (int i= input,leng = input,other= input,temp = 0; i >0; i--,other--,leng++, temp=0) {
            //int temp = 0;
            for (int j = 1; j <=leng; j++) {
                System.out.print((j<other)?" ":(j<=input)?++temp:--temp);
            }
            System.out.println();
        }
*/

        for (int i= input,leng = input,other= input; i >0; i--,other--,leng++) {
            int temp = 0;
            for (int j = 1; j <=leng; j++) {
                if (j<other){
                System.out.print(" ");
                }else {
                    if (j<=input){
                        System.out.print(++temp);
                    }else
                        System.out.print(--temp);
                }
            }
            System.out.println();
        }
    }
}
