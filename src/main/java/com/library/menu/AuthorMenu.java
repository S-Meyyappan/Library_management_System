package com.library.menu;

import com.library.controller.AuthorController;
import com.library.controller.MemberController;
import com.library.enums.MemberType;
import com.library.model.Author;
import com.library.model.Member;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AuthorMenu implements Menu{
    @Override
    public void displayMenu() {
        Scanner in = new Scanner(System.in);

        AuthorController authorController = new AuthorController();

        System.out.println("-------------------Author Menu-------------------");
        while (true){
            System.out.println("1. Add a new Author");
            System.out.println("2. Find Author by Id");
            System.out.println("3. Fetch all authors");
            System.out.println("4. Update a author");
            System.out.println("5. Delete a author");
            System.out.println("0. Go Back");
            System.out.println("----------------------------------------------");

            System.out.println("Enter your choice: ");
            int choice = in.nextInt();

            if(choice == 0){
                System.out.println("Going to main menu...");
                return;
            }

            switch (choice){
                case 1 -> {
                    System.out.println("----------------Enter author details----------------");
                    in.nextLine();
                    System.out.println("Enter name: ");
                    String name = in.nextLine();
                    System.out.println("Enter country: ");
                    String country = in.nextLine();

                    Author author = new Author();
                    author.setName(name);
                    author.setCountry(country);

                    try {
                        author = authorController.addAuthor(author);
                        System.out.println("Author added successfully: " + author);
                    } catch (Exception e) {
                        System.out.println("Failed to add Author: " + e.getMessage());
                    }
                }

            }

        }
    }
}
