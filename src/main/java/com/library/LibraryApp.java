package com.library;

import com.library.config.HbmConfig;
import com.library.controller.BookController;
import com.library.enums.BookStatus;
import com.library.enums.Genre;
import com.library.menu.StudentMenu;
import com.library.model.Author;
import com.library.model.Book;
import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("----------------------Library Management System----------------------");

        Scanner in = new Scanner(System.in);

        BookController bookController = new BookController();

        while (true) {
            System.out.println("""
            ==== Main Menu ====
            1. Student
            2. Course
            3. Teacher
            0. Exit
            -------------------""");

            System.out.print("Enter your choice: ");
            int choice = in.nextInt();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1 -> new StudentMenu().displayMenu();
            }
        }


    }
}
