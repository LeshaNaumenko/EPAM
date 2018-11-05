package controller.service;

import model.Books;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOService extends AbsService {

    public String readFromFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public void writeToFileSer(Books books, String path) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(String.valueOf(Files.createFile(Paths.get(path)))))) {
            objectOutputStream.writeObject(books);

        }
    }

}
