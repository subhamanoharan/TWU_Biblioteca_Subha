package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

//Test the biblioteca class
public class LibraryTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldDisplayWelcomeMessage() {
        Library biblioteca = new Library("Biblioteca");
        biblioteca.displayWelcomeMessage();
        assertEquals("Welcome to Biblioteca!!\n", outContent.toString());
    }

    @Test
    public void shouldprintBooksUnAvailable() {
        Library biblioteca = new Library("Biblioteca");
        biblioteca.displayListOfBooks();
        assertEquals("NO BOOKS CURRENTLY AVAILABLE FOR CHECKOUT\n", outContent.toString());
    }

    @Test
    public void shouldprintBooksAvailable() throws IOException {
        Library biblioteca = new Library("Biblioteca");
        biblioteca.addBook(new Book("Head First Java", "Kerry Bates", 1990));
        biblioteca.addBook(new Book("Harry Potter and the Philosopher's stone", "J.K.Rowling", 2001));
        biblioteca.displayListOfBooks();
        verifyOutput(outContent.toString(), "BooksList");
    }

    @Test
    public void shouldValidateNewBookAddition() {
        Library biblioteca = new Library("Biblioteca");
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        biblioteca.addBook(book);
        assertTrue(biblioteca.isPresent(book));
    }

    @Test
    public void shouldGetExistingBookByTitle() {
        Library biblioteca = new Library("Biblioteca");
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        biblioteca.addBook(book);
        assertEquals(biblioteca.getBookByTitle("Head First Java"), book);
    }

    @Test
    public void shouldSearchForNonExistingBookByTitle() {
        Library biblioteca = new Library("Biblioteca");
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        biblioteca.addBook(book);
        assertEquals(biblioteca.getBookByTitle("Head "), null);
    }

    @Test
    public void shouldValidateSuccessfulCheckout() {
        Library biblioteca = new Library("Biblioteca");
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        biblioteca.addBook(book);
        biblioteca.checkOutBook("Head First Java");
        assertEquals("Successful Checkout!\nEnjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldValidateUnSuccessfulTypoCheckout() {
        Library biblioteca = new Library("Biblioteca");
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        biblioteca.addBook(book);
        String title = "Head First";
        biblioteca.checkOutBook(title);
        assertEquals("Unsuccessful checkOut:" + title + " doesn't exist!Check your spelling!\n", outContent.toString());
    }

    @Test
    public void shouldValidateUnSuccessfulUnavailableCheckout() {
        Library biblioteca = new Library("Biblioteca");
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        biblioteca.addBook(book);
        String title = "Head First Java";
        biblioteca.checkOutBook(title);
        biblioteca.checkOutBook(title);
        assertEquals("Successful Checkout!\n" +
                "Enjoy the book\nUnsuccessful Checkout!\n" + title + " is not available currently!\n", outContent.toString());
    }



    /*@Test
    public void out() {
        System.out.println("hello");
        assertEquals("hello\n", outContent.toString());
    }*/

    protected void verifyOutput(String actualValue, String fileName) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("test/data" + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        String thisFileLine;
        while ((thisFileLine = file.readLine()) != null) {
            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
