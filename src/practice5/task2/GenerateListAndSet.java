package practice5.task2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateListAndSet {

    //I forgot what the problem was(

    List<Integer> list;
    Set<Integer> set;

    public GenerateListAndSet(int numbOfElements, int ownCapacity ) {
        this.list = new ArrayList<>(ownCapacity);
        this.set = new HashSet<>(ownCapacity);

        for (int i = 0; i < numbOfElements; i++) {
            list.add(i);
            set.add(i);
        }
    }

    @Override
    public String toString() {
        int capacity =0;
        try {
            capacity = getCapacity(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "GenerateListAndSet{" +
                "\nlist=" + list +
                ", \nset=" + set +
                ", \nsize of list=" +capacity +
                '}';
    }
    public static int getCapacity(List<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }

}

