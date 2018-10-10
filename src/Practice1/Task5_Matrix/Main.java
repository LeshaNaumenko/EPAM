package Practice1.Task5_Matrix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size of the matrix:");
        int input = scanner.nextInt();
        int[][] myArray = new int[input][input];

        myArray = fill(myArray);
        printMatrix(myArray);

        turnedOn90DegreesToTheLeft(myArray);
        System.out.println();
        printMatrix(myArray);

    }

    private static int[][] turnedOn90DegreesToTheLeft(int[][] myArray) {

            int temp3=0;
            int ln;
        for (int i = 0, i2=0, myLength =myArray.length-1; i <=myArray.length/2; i++, i2++, myLength--) {
            temp3=i2;
            ln = myLength;
            for (int j = temp3,myLength2 = ln; j <myLength; j++, myLength2-- ) {


                int temp = myArray[i2][j];
                int temp2 = myArray[myLength2][i2];
                myArray[i2][j] = myArray[j][myLength];
                myArray[j][myLength2]=myArray[myLength][myLength2];
                myArray[myLength2][temp3]= temp;
                myArray[myLength][myLength2] = temp2;
            }

        }
            return myArray;

    }

    public static void printMatrix(int[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                System.out.print(myArray[i][j]+" ");
            }

            System.out.println();
        }
    }

    public static int[][] fill(int[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                myArray[i][j] = i;
            }
            System.out.println();
        }
        return myArray;
    }
}
