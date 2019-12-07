package com.drawingprogram.app;

import static com.drawingprogram.app.Constants.EMPTY_CANVAS204;
import static com.drawingprogram.app.Constants.EMPTY_CANVAS35;
import static com.drawingprogram.app.Constants.FILL103;
import static com.drawingprogram.app.Constants.LINE1214;
import static com.drawingprogram.app.Constants.RECTANGLE141183;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for console App.
 */
public class AppTest {
    ByteArrayOutputStream outContent;

    @BeforeEach
    private void setOutputStream() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCommandNotValid() throws Exception {
        App app = new App();
        app.draw("C 20");
        assertEquals("\nCommand not valid, try again with right number of arguments.\n\n", outContent.toString());
    }

    @Test
    public void testCanvas() throws Exception {
        App app = new App();
        app.draw("C 20 4");
        assertEquals(EMPTY_CANVAS204 + "\n", outContent.toString());
    }

    @Test
    public void testLine() throws Exception {
        App app = new App();
        app.draw("C 3 5");
        app.draw("L 1 2 1 4");
        assertEquals(EMPTY_CANVAS35 + "\n" + LINE1214 + "\n", outContent.toString());
    }

    @Test
    public void testRectangle() throws Exception {
        App app = new App();
        app.draw("C 20 4");
        app.draw("R 14 1 18 3");
        assertEquals(EMPTY_CANVAS204 + "\n" + RECTANGLE141183 + "\n", outContent.toString());
    }

    @Test
    public void testFill() throws Exception {
        App app = new App();
        app.draw("C 20 4");
        app.draw("B 10 3 o");
        assertEquals(EMPTY_CANVAS204 + "\n" + FILL103 + "\n", outContent.toString());
    }

    @Test
    public void testException() throws Exception {
        App app = new App();
        app.draw("C 0 4");
        assertEquals("\nError: Canvas measurements cannot be less than 1\nplease try again\n", outContent.toString());
    }
}
