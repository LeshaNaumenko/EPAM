package practice5.task2;

import java.lang.reflect.Field;
import java.util.*;

public class GenerateListAndSet {

    //I forgot what the problem was(

    List<Integer> list;
    Set<Integer> set;

    public GenerateListAndSet(int size, int min, int max    ) {
        this.list = new ArrayList<>();
        this.set = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int temp= (random.nextInt(max-min)+max);
            if (list.contains(temp)){
                i--;
            }else {
                list.add(temp);
                set.add(temp);
            }
        }
    }

    @Override
    public String toString() {
        return "GenerateListAndSet{" +
                "\nlist=" + list +
                ", \nset=" + set +
                '}';
    }
}

