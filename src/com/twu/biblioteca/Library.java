package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Represent a library with a collection of books
public class Library {
    List<Book> books = new ArrayList<Book>();
    List<Customer> customers = new ArrayList<Customer>();
    String name;

    Library(String name) {
        this.name = name;
    }

    public static void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!!");
    }

    public void displayListOfBooks() {
        if (books.size() == 0)
            System.out.println("NO BOOKS CURRENTLY AVAILABLE FOR CHECKOUT");
        else {
            System.out.print("BOOKS AVAILABLE\n");
            System.out.format("%-70s%-70s%-70s\n",
                    "Title", "Author", "Year Of Publishing");
            for (Book book : books) {
                book.printDetails();
            }
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean isPresent(Book book) {
        if (books.contains(book))
            return true;
        return false;
    }

    public Book getBookByTitle(String title)
    {
        for (Book b : books)
        {
            if ( (b.getTitle()).equals(title) )
                return b;
        }
        return null;
    }

    public void checkOutBook(String title) {
        Book b = getBookByTitle(title);
        if( b == null )
            System.out.println( "Unsuccessful checkOut:" + title + " doesn't exist!Check your spelling!");
        else
            b.checkOut();
    }

    public void returnBook(String title) {
        Book b = getBookByTitle(title);
        if( b == null)
            System.out.println ("That is not a valid book to return.");
        else
        b.returnBack();
    }
}
