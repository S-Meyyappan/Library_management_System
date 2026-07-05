package com.library;

import com.library.controller.BookController;
import com.library.menu.AuthorMenu;
import com.library.menu.BookMenu;
import com.library.menu.MemberMenu;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BookController bookController = new BookController();

        System.out.println("----------------------Library Management System----------------------");

        while (true) {
            System.out.println("""
            ==== Main Menu ====
            1. Book
            2. Member
            3. Author
            0. Exit
            -------------------""");

            System.out.print("Enter your choice: ");
            int choice = in.nextInt();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1 -> new BookMenu().displayMenu();
                case 2 -> new MemberMenu().displayMenu();
                case 3 -> new AuthorMenu().displayMenu();
            }
        }
    }
}
