package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    static Library biblioteca=new Library("Biblioteca");

    public static int displayMenuAndGetUserChoice() throws IOException {

        System.out.println("\n1)Display the list of available books");
        System.out.println("2)Quit");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public static void runConsole() throws IOException {
        biblioteca.displayWelcomeMessage();
        while(true) {
            int choice = displayMenuAndGetUserChoice();
            biblioteca.performActionChosen(choice);
            if (choice == 2 )
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        biblioteca.addBook(new Book("Head First Java", "Kerry Bates", 1990));
        biblioteca.addBook(new Book("Harry Potter and the Philosopher's stone", "J.K.Rowling", 2001));
        runConsole();
    }

}
