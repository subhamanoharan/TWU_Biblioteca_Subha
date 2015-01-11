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

    public boolean equals(Customer customer)
    {
        if (customer == null)
            return false;
        if ( name == customer.name &&
                libraryNumber == customer.libraryNumber &&
                email == customer.email &&
                phoneNumber == customer.phoneNumber &&
                password == customer.password)
            return true;
        return false;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }
}
