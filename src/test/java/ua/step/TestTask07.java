package ua.step;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task07;

public class TestTask07 {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void test1() {
        Task07.main(new String[] { "3" });
        assertEquals("1.7320508075688772", outContent.toString().trim());
    }

    @Test
    public void test2() {
        Task07.main(new String[] { "9" });
        assertEquals("3.0", outContent.toString().trim());
    }

    @Test
    public void test3() {
        Task07.main(new String[] { "256" });
        assertEquals("16.0", outContent.toString().trim());
    }

    @Test
    public void test4() {
        Task07.main(new String[] { "-3" });
        assertEquals("NaN", outContent.toString().trim());
    }
}