package practice5.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    private Map<String, String> dictionary = new HashMap();
    {
        dictionary.put("hello", "привет");
        dictionary.put("i", "я");
        dictionary.put("want", "хочу");
        dictionary.put("to", "\b");
        dictionary.put("be", "быть");
        dictionary.put("Java", "Java");
    }

    public void addWord(String eng, String rus ){
        dictionary.put(eng, rus);
    }

    public String translate(String sentence){
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = sentence.toLowerCase().split("[ _,.]");
        for (String s : split) {
            if (dictionary.containsKey(s)){
                stringBuilder.append(dictionary.get(s)+" ");
            }else {
                stringBuilder.append(s+" ");
            }
        }
        return stringBuilder.toString();
    }
}
