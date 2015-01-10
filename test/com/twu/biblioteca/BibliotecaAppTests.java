package com.twu.biblioteca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import static com.sun.deploy.security.DeployManifestChecker.verify;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

//To test the biblioteca app
public class BibliotecaAppTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void checkOptionDisplayBooks() throws IOException {
        BibliotecaApp.performActionChosen(1);
        assertEquals("NO BOOKS CURRENTLY AVAILABLE FOR CHECKOUT\n", outContent.toString());
    }


    @Test
    public void checkOptionQuit() throws IOException {
        BibliotecaApp.performActionChosen(2);
        assertEquals("Thanks For Visting Us!!\n", outContent.toString());
    }

    @Test
    public void checkInvalidOption() throws IOException {
        BibliotecaApp.performActionChosen(15);
        assertEquals("Invalid Menu option\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
