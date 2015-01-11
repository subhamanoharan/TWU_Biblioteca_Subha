package com.twu.biblioteca;

/**
 * Created by subham on 11/01/15.
 */
public class Customer {
    private String libraryNumber;
    private String password;
    private String name,email,phoneNumber;

    Customer(String name, String email, String phoneNumber,String libraryNumber, String password)
    {
        this.name=name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public void checkOutBook()
    {

    }
}
