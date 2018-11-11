package controller.service;

import static org.junit.Assert.*;

import model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceWordProcessingTest {

    public static ServiceWordProcessing serviceWordProcessing;
    @BeforeClass
    public static void setUp() {
        serviceWordProcessing = new ServiceWordProcessing();
    }

    String original = "A simple text scanner which can parse primitive types and strings using regular expressions.\n" +
            "A Scanner breaks its input into tokens using a delimiter pattern, which by default matches whitespace. The resulting tokens may then be converted into values of different types using the various next methods.";
    String result = "A simple text  which can parse primitive types and  using  expressions.\n" +
            "A  breaks its input into tokens using a delimiter , which by   whitespace. The resulting tokens may then be converted into values of different types using the  next .";
    @Test
    public void t() {
        Assert.assertEquals(result, serviceWordProcessing.textHandling(original, 7));
    }
}