package practice8.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
    Map<Integer, Integer> map;
        final int COUNT = 10000;
    public void run(){
        testHashMap();
        testConcurrentHashMap();
    }

    private void testConcurrentHashMap() {
        map = new ConcurrentHashMap<>();
        Thread[] threadsWrite = new Thread[COUNT];
        Thread[] threadsRead = new Thread[COUNT];

        for (int i = 0; i < COUNT; i++) {
            int c = i;
            threadsWrite[i] = new Thread(() ->{
                    map.put(c,c);
            });
            threadsRead[i] = new Thread(()->{
                    map.get(c);
            });
        }
        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            threadsWrite[i].start();
            threadsRead[i].start();
        }
        for (int i = 0; i < COUNT; i++) {
            try {
                threadsWrite[i].join();
                threadsRead[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        long end = System.nanoTime();
        System.out.println("\nTime = "+(end-start)/1000000000.0);
    }

    private void testHashMap() {
        map = new HashMap<>();
        Thread[] threadsWrite = new Thread[COUNT];
        Thread[] threadsRead = new Thread[COUNT];

        for (int i = 0; i < COUNT; i++) {
            int c = i;
            threadsWrite[i] = new Thread(() ->{
                //synchronized (map){
                    map.put(c,c);
                //}
            });
            threadsRead[i] = new Thread(()->{
                //synchronized (map){
                    map.get(c);
                //}
            });
        }
        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            threadsWrite[i].start();
            threadsRead[i].start();
        }
        for (int i = 0; i < COUNT; i++) {
            try {
                threadsWrite[i].join();
                threadsRead[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        long end = System.nanoTime();
        System.out.println("\nTime = "+(end-start)/1000000000.0);
    }
}
