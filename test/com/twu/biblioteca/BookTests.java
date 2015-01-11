package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by subham on 11/01/15.
 */
public class BookTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void checkAvailability()
    {
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        assertTrue(book.getAvailability());
    }

    @Test
    public void validatePrintDetails()
    {
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        book.printDetails();
        assertEquals("Head First Java                                                       Kerry Bates                                                           1990                                                                  \n", outContent.toString());
    }

    @Test
    public void validateSuccessfulCheckOut()
    {
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        book.checkOut();
        assertEquals("Successful Checkout!\nEnjoy the book\n", outContent.toString());

    }

    @Test
    public void validateUnavailableCheckOut()
    {
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        book.checkOut();
        book.checkOut();
        assertEquals("Successful Checkout!\nEnjoy the book\nUnsuccessful Checkout!\n"+book.getTitle()+" is not available currently!\n", outContent.toString());
    }

    @Test
    public void validateSuccessfulReturn()
    {
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        book.checkOut();
        book.returnBack();
        assertEquals("Successful Checkout!\nEnjoy the book\nThank you for returning the book.\n", outContent.toString());

    }

    @Test
    public void validateUnSuccessfulReturn()
    {
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        book.returnBack();
        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
