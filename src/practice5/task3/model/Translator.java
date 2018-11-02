package practice5.task3.model;

import java.util.HashMap;
import java.util.Map;

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

    public boolean addWord(String eng, String rus ){
        if (dictionary.containsKey(eng)) return false;
        dictionary.put(eng, rus);
        return true;
    }

    public String translate(String sentence){
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = sentence.toLowerCase().split(" ");
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
