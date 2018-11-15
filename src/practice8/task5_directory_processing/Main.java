package practice8.task5_directory_processing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {

        File file = new File("E:\\Java\\EPAM\\src\\practice8\\task5_directory_processing\\files");
        File result = new File("E:\\Java\\EPAM\\src\\practice8\\task5_directory_processing\\Result.txt");

        WordSearchClass d = new WordSearchClass(file, 'd', result);
        FutureTask<List<Map.Entry<String, Integer>>> entryFutureTask = new FutureTask<>(d);
        new Thread(entryFutureTask).start();
    }
}

class WordSearchClass implements Callable<List<Map.Entry<String, Integer>>> {
    private final File root;
    private final char symbol;
    private final File writeTo;

    public WordSearchClass(File root, char symbol, File writeTo) {
        this.root = root;
        this.symbol = symbol;
        this.writeTo = writeTo;
    }

    @Override
    public List<Map.Entry<String, Integer>> call() throws Exception {

        System.out.println(Thread.currentThread().getName());
        File[] files = root.listFiles();

        List<Future<List<Map.Entry<String, Integer>>>> result = new ArrayList<>();

        for (File file : files) {

            if (file.isDirectory()) {
                System.out.println("I'm here");
                WordSearchClass wordSearchClass = new WordSearchClass(file, symbol, writeTo);
                FutureTask<List<Map.Entry<String, Integer>>> task = new FutureTask<>(wordSearchClass);
                result.add(task);
                new Thread(task).start();
            } else {
                String[] split = file.getPath().split("\\.");
                System.out.println(split[split.length - 1]);
                if (split[split.length - 1].equals("txt")) {
                    int search = search(file);
                    Map<String, Integer> map = new HashMap<>();
                    map.put(file.getAbsolutePath(), search);
                    return new ArrayList<>(map.entrySet());
                }
            }
        }
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("0",0);
        return new ArrayList<>(stringIntegerHashMap.entrySet());
    }

    private int search(File file) {
        int sum = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] s1 = s.split(" ");
                for (int i = 0; i < s1.length; i++) {
                    System.out.println(s1[i].charAt(0));
                    if (s1[i].charAt(0) == symbol) {
                        sum++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            return 0;
        }
        return sum;
    }
}