package controller.service;

import model.Books;
import model.entity.Book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class IOService extends AbsService {

    public String readFromTXT(String path) throws IOException {
        Path p = Paths.get(path);
        if (Files.exists(p)) {
            return new String(Files.readAllBytes(Paths.get(path)));
        }
        return null;
    }

    public void writeToFileSer(Books books, String path) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(String.valueOf(Files.createFile(Paths.get(path)))))) {
            objectOutputStream.writeObject(books);
        }
    }

    public void writeToTXT(Books books, String path) {


    }

    public Book[] readFromJSON(String path) {
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
