package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Represent a library with a collection of books
public class Library {
    List<Book> books = new ArrayList<Book>();
    List<Customer> customers = new ArrayList<Customer>();
    HashMap<Book,Customer> ledger;
    String name;

    Library(String name) {
        this.name = name;
        ledger = new HashMap<Book, Customer>();
    }

    public  void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!!");
    }

    public void performActionChosen(int option) throws IOException {
        switch(option)
        {
            case 1:
                BibliotecaApp.biblioteca.displayListOfBooks();
                break;
            case 2:
                System.out.println("Thanks For Visting Us!!");
                break;
            default:
                System.out.println("Invalid Menu option");
        }
    }

    public void displayListOfBooks() {
        if (books.size() == 0)
            System.out.println("NO BOOKS CURRENTLY AVAILABLE FOR CHECKOUT");
        else {
            System.out.print("BOOKS AVAILABLE\n");
            System.out.format("%-70s%-70s%-70s\n",
                    "Title", "Author", "Year Of Publishing");
            for (Book book : books) {
                if(book.getAvailability() == true)
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


    public Customer searchCustomerByLibraryNumber(String libraryNumber)
    {
        for (Customer customer : customers)
        {
            if ( (customer.getLibraryNumber()).equals(libraryNumber) )
                return customer;
        }
        return null;
    }

    public void checkOutBook( Customer customer, String title) {
        Book book = getBookByTitle(title);
        if (book == null)
            System.out.println("Unsuccessful checkOut:" + title + " doesn't exist!Check your spelling!");
        else {
            if( book.checkOut()) {
                ledger.put(book,customer);
            }
        }
    }

    public void returnBook(String title,Customer customer) {
        Book b = getBookByTitle(title);
        Customer ledgerEntry = ledger.get(b);
        if( b == null)
            System.out.println ("That is not a valid book to return.");
        else {
            if( ledgerEntry!=null && ledgerEntry.equals(customer) && b.returnBack()) {
                ledger.remove(b);
            }
            else
                System.out.println("That is not a valid book to return.");

        }
    }

    public void addCustomer(Customer newCustomer)
    {
        customers.add(newCustomer);
    }

}
