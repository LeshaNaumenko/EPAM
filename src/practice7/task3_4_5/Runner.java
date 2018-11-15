package practice7.task3_4_5;

import java.util.*;
import java.util.function.Predicate;

public class Runner {

    public void run() {
        Integer[] integer = createInteger(12);
        System.out.println("Array: " + Arrays.toString(integer));
        Arrays.sort(integer, Comparator.reverseOrder());
        System.out.println("Array after:    " + Arrays.toString(integer));
        System.out.println("==============");
        List<String> listStrings = createListStrings();
        System.out.println("listStrings = " + listStrings);

        Collections.reverse(listStrings);
        System.out.println("new listStrings = " + listStrings);
        System.out.println("==============");
        System.out.println("sum = " + sum(integer,
                x -> x > 10 && x % 3 == 0));
        System.out.println("==============");

        System.out.println("select" + selectStringByChar(listStrings, o1 -> o1.startsWith("c") || o1.startsWith("v")));
        System.out.println("==============");
        updateListString(listStrings, x->x.toUpperCase());

        System.out.println(listStrings);
    }

    private Integer[] createInteger(int size) {

        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(20);
        }

        return array;
    }

    public List<String> createListStrings() {

        List<String> strings = new ArrayList<>();

        for (char i = 'a'; i < 'z'; i++) {
            strings.add("" + i + i);
        }
        Collections.shuffle(strings);
        return strings;
    }

    public int sum(Integer[] array, Predicate<Integer> predicate) {
        int ss = 0;
        for (Integer integer : array) {
            if (predicate.test(integer)) {
                ss += integer;
            }
        }
        return ss;
    }

    public List<String> selectStringByChar(List<String> list, Predicate<String> p) {
        List<String> neeList = new ArrayList<>();


        for (String s : list) {
            if (p.test(s)) {
                neeList.add(s);
            }
        }
        return neeList;
    }

    public void updateListString(List<String> list, ConvertString convertString){
        for (int i = 0; i < list.size(); i++) {
            if(!convertString.isNull(list.get(i))){
                list.set(i, convertString.convert(list.get(i)));

            }
        }
    }
}
