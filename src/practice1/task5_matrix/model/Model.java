package practice1.task5_matrix.model;

public class Model {

    int[][] myArray;

    public void setMyArray(int[][] myArray) {
        this.myArray = myArray;
    }

    public int[][] getMyArray() {
        return myArray;
    }

    public int[][] turnedOn90DegreesToTheLeft() {
        int temp3;
        int ln;
        for (int i = 0, i2 = 0, myLength = myArray.length - 1; i <= myArray.length / 2; i++, i2++, myLength--) {
            temp3 = i2;
            ln = myLength;
            for (int j = temp3, myLength2 = ln; j < myLength; j++, myLength2--) {
                int temp = myArray[i2][j];
                int temp2 = myArray[myLength2][i2];
                myArray[i2][j] = myArray[j][myLength];
                myArray[j][myLength] = myArray[myLength][myLength2];
                myArray[myLength2][temp3] = temp;
                myArray[myLength][myLength2] = temp2;
            }
        }
        return myArray;

    }
}
