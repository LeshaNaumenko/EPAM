package practice5.task3.controller;

import practice5.task3.model.Translator;

public class Service {

    private Translator model;


    public Service(Translator model) {
        this.model = model;
    }

    public boolean addWord(String eng, String rus ){
        return model.addWord(eng, rus);
    }

    public String translate(String sentence){
        return model.translate(sentence);
    }
}
