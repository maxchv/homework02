package ua.step;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.homework.BaseTest;
import ua.step.homework.Task01;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestTask01 extends BaseTest {

    private final String number;
    private final String name;

    @Parameterized.Parameters
    public static Collection<Object[]> weeks() {
        return Arrays.asList(new Object[][]{
                {"1", "понедельник"},
                {"2", "вторник"},
                {"3", "среда"},
                {"4", "четверг"},
                {"5", "пятница"},
                {"6", "суббота"},
                {"7", "воскресенье"},
        });
    }

    public TestTask01(String weekNumber, String weekName) {
        this.number = weekNumber;
        this.name = weekName;
    }

    @Before
    public void setUpInput() {
        System.setIn(new ByteArrayInputStream(this.number.getBytes()));
    }

    @Test
    public void test() {
        Task01.main(null);
        String out = outContent.toString();
        int idx = out.indexOf(":");
        assertEquals(name, out.substring(idx+1).toLowerCase().trim());
    }
}