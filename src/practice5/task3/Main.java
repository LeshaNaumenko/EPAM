package practice5.task3;

import practice5.task3.model.Translator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sentence in English:");
        String s = scanner.nextLine();



        Translator translator = new Translator();
        translator.addWord("world", "мир");
        System.out.println(translator.translate(s));
    }
}
