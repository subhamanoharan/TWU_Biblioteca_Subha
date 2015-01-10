package com.twu.biblioteca;

/**
 * Created by subham on 10/01/15.
 */
public class Book {
    private String title, author;
    private int yearPublished;

    Book(String title, String author, int yearPublished)
    {
        this.title=title;
        this.author=author;
        this.yearPublished=yearPublished;
    }

    public void printDetails() {
        System.out.format("%-70s%-70s%-70s\n",
                title, author, yearPublished);
        // System.out.print(title + "                 " + author + "                      " + yearPublished + "\n");
    }
}
