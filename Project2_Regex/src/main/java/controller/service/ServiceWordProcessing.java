package controller.service;

import model.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceWordProcessing {

    //согласные буквы
    public static final String CONSONANT= "b|c|d|f|g|h|j|k|l|m|n|p|q|r|s|t|v|w|x|y|z|B|C|D|F|G|H|J|K|L|M|N|P|Q|R|S|T|V|W|X|Y|Z";
    private Book model;

    public Book getModel() {
        return model;
    }

    public void setModel(Book model) {
        this.model = model;
    }

    public String getModelFromFile(String path) throws IOException {
        Path p = Paths.get(path);
        if (Files.exists(p)) {
            return new String(Files.readAllBytes(Paths.get(path)));
        }
        return null;
    }

    public Book createModel(String text) {
        return new Book(text);
    }

    public String textHandling(String text, int length) {
        Pattern compile = Pattern.compile("\\b("+ServiceWordProcessing.CONSONANT+")\\w{" + (length - 1) + "}\\b");
        Matcher ff = compile.matcher(text);
        StringBuilder stringBuilder = new StringBuilder(text);
        int temp = 0;
        while (ff.find()) {
                stringBuilder.delete(ff.start()-temp, ff.end()-temp);
//                System.out.print(ff.group());
//                System.out.print(", start:" + ff.start());
//                System.out.println(", end:" + ff.end());
                temp+=length;
        }
        return stringBuilder.toString();
    }
}
