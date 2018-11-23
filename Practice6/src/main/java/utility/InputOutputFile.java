package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Books;
import model.entity.Book;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class InputOutputFile {
    public static String readFromTXT(String path)  {
        Path p = Paths.get(path);
        if (Files.exists(p)) {
            try {
                return new String(Files.readAllBytes(Paths.get(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void writeToFileSer(Books books, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(String.valueOf(Files.createFile(Paths.get(path)))))) {
            objectOutputStream.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToTXT(Books books, String path) {

        try (FileWriter fileWriter = new FileWriter(path)){
            fileWriter.write(Arrays.toString(books.getBooks()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Book[] readFromJSON(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        Book[] books = null;
        try {
            books = objectMapper.readValue(Files.readAllBytes(Paths.get(path)), Book[].class);
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
