package com.twu.biblioteca;

/**
 * Created by subham on 10/01/15.
 */
public class Book {
    private String title, author;
    private int yearPublished;
    private boolean availabilty;

    Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.availabilty = true;
    }

    public void printDetails() {
        System.out.format("%-70s%-70s%-70s\n",
                title, author, yearPublished);
    }

    public String getTitle() {
        return title;
    }

    public boolean checkOut() {
        if (availabilty == true) {
            availabilty = false;
            System.out.println("Successful Checkout!");
            System.out.println("Enjoy the book");
            return true;
        } else {
            System.out.println("Unsuccessful Checkout!");
            System.out.println(title + " is not available currently!");
            return false;
        }

    }

    public boolean returnBack() {
        if (availabilty)
            System.out.println("That is not a valid book to return.");
        else {
            availabilty = true;
            System.out.println("Thank you for returning the book.");
            return true;
        }
        return false;
    }

    public boolean getAvailability() {
        return availabilty;
    }
}
