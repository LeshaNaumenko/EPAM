package practice1.task5_matrix.view;

public class View {
    public void printMatrix(int[][] myArray){
        for (int[] ints : myArray) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
