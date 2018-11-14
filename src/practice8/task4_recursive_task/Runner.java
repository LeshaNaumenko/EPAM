package practice8.task4_recursive_task;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Runner {

    private static int N = 1000_000;
    private static final int NUMBER_THREADS = 8;

    static class SumOfArray extends RecursiveTask<Long>{
        long[] array;
        long from, to;

        public SumOfArray(long from, long to, long[] array) {
            this.array = array;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to-from)<=20){

                long localSum = 0;

                for (int i = (int)from; i <to ; i++) {
                    localSum+=array[i];
                }
                System.out.printf("Sum:%d to %d  =  %d %n", from, to, localSum);
                return localSum;
            }else {
                long mid = (from+to)/2;
                System.out.printf("Forking:%d to %d  AND  %d to  %d %n", from, mid,mid, to);

                SumOfArray firstHalf = new SumOfArray(from, mid, array);
                firstHalf.fork();
                SumOfArray secondHalf = new SumOfArray(mid, to, array);
                long resultSecond = secondHalf.compute();
                return firstHalf.join()+resultSecond;

            }

        }
    }

    public static void main(String[] args) {

        long [] array = new long[N];
        random(array);
        System.out.println(Arrays.toString(array));
        ForkJoinPool pool = new ForkJoinPool(NUMBER_THREADS);
        Long invoke = pool.invoke(new SumOfArray(0, array.length, array));


        long sum=0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        System.out.println(invoke +" =? "+ sum );


    }

    public static void random(long[] array){

        Random random = new Random();

        for (int i=0;i<array.length;i++) {
            array[i]=random.nextInt(100);
        }
    }

}
