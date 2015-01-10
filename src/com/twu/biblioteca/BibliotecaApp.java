package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    static Library biblioteca=new Library("Biblioteca");

    public static int displayMenuAndGetUserChoice() throws IOException {

        System.out.println("1)Display the list of available books");
        System.out.println("2)Quit");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public static void performActionChosen(int option) throws IOException {
        switch(option)
        {
            case 1:
                biblioteca.displayListOfBooks();
                break;
            case 2:
                System.out.println("Thanks For Visting Us!!");
                break;
            default:
                System.out.println("Invalid Menu option");
        }
    }

    public static void main(String[] args) throws IOException {
        biblioteca.addBook(new Book("Head First Java", "Kerry Bates", 1990));
        biblioteca.addBook(new Book("Harry Potter and the Philosopher's stone", "J.K.Rowling", 2001));

        biblioteca.displayWelcomeMessage();
        while(true) {
            int choice = displayMenuAndGetUserChoice();
            performActionChosen(choice);
            if (choice == 2 )
                break;
        }
    }

}
