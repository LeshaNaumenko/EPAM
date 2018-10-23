import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TestTemperature {
    TemperatureConverter temperatureConverter;

    @Before
    public void initialize() {
        temperatureConverter = new TemperatureConverter();
    }

    @Parameterized.Parameter()
    public double expected1;
    @Parameterized.Parameter(1)
    public double value1;
    @Parameterized.Parameter(2)
    public double expected2;
    @Parameterized.Parameter(3)
    public double value2;
    @Parameterized.Parameter(4)
    public double expected3;
    @Parameterized.Parameter(5)
    public double value3;
    @Parameterized.Parameter(6)
    public double expected4;
    @Parameterized.Parameter(7)
    public double value4;
    @Parameterized.Parameter(8)
    public double expected5;
    @Parameterized.Parameter(9)
    public double value5;
    @Parameterized.Parameter(10)
    public double expected6;
    @Parameterized.Parameter(11)
    public double value6;

    @Test
    public void test1() {
        assertEquals("everything is bad", expected1, temperatureConverter.convertFtoC(value1), 0.1);
    }

    @Test
    public void test2() {
        assertEquals("ERROR", expected2, temperatureConverter.convertCtoF(value2), 0.1);
    }

    @Test
    public void test3() {
        assertEquals("ERROR", expected3, temperatureConverter.convertCtoK(value3), 0.1);
    }
    @Test
    public void test4() {
        assertEquals("ERROR", expected4, temperatureConverter.convertKtoC(value4), 0.1);
    }
    @Test
    public void test5() {
        assertEquals("ERROR", expected5, temperatureConverter.convertFtoK(value5), 0.1);
    }
    @Test
    public void test6() {
        assertEquals("ERROR", expected6, temperatureConverter.convertKtoF(value6), 0.1);
    }

    @Parameterized.Parameters(name = "{index}:sumOf({0} ={1})")
    public static Collection paramForTest() {

        return Arrays.asList(new Double[][]{
                {-12.1, 10.1,   50.0, 10.0, 274.2, 1.0,  -274.2, -1.0,  260.2, 8.7,  -422.9, 20.44},
                {-24.5, -12.1,  51.8, 11.0, 284.2, 11.0, -260.2, 13.0,  265.7, 18.7, -458.4, 0.7},
                {-17.1, 1.1,    53.5, 12.0, 285.2, 12.0, -302.2, -29.0, 250.5, -8.7, -455.38, 2.4},
                {-13.8, 7.0,    55.4, 13.0, 286.2, 13.0, -233.2, 40.0,  261.8, 11.7, -440.548, 10.64},
                {-12.2, 10.0,   57.2, 14.0, 287.2, 14.0, -253.2, 20.0,  264.1, 15.7, -448.126, 6.43},
                {-17.7, 0.0,    59.0, 15.0, 288.2, 15.0, -287.2, -14.0, 253.8, -2.7, -490.3, -17.0}
        });
    }
}
