package com.epam.task61.util;

import com.epam.task61.model.data.DataSource;
import com.epam.task61.model.entity.Book;
import org.apache.log4j.Logger;

import java.io.*;


public class InputOutputFile {
    final static Logger logger =
            org.apache.log4j.Logger.getLogger(InputOutputFile.class);
    private static File file =
            new File("E:\\Java\\EPAM_Lecture_task6.1\\src\\main\\resources\\data.ser");

    public static Book[] load() {
        try (ObjectInput oi = new ObjectInputStream(
                new FileInputStream(file))){
            return (Book[])oi.readObject();
        } catch (FileNotFoundException exp) {
            logger.info("File not found!");
            return DataSource.getBooks();
        } catch (IOException | ClassNotFoundException exp) {
            exp.printStackTrace();
            logger.error("Error read");
            return new Book[0];
        }
    }

    public static void save(Book[] books) {
        try (ObjectOutput oo = new ObjectOutputStream(
                new FileOutputStream(file))){
            oo.writeObject(books);
        } catch (FileNotFoundException exp) {
            logger.info("File not found");
        } catch (IOException exp) {
            logger.error("Error write");
        }
    }
}
