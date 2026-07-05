package com.library.menu;

import com.library.controller.AuthorController;
import com.library.model.Author;
import com.library.model.Member;

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
                case 2 -> {
                    System.out.println("----------------Find Author by Id----------------");
                    System.out.println("Enter author Id :");
                    long id = in.nextLong();
                    Author author = authorController.findAuthorById(id);
                    if (author != null) {
                        System.out.println("Author found: " + author);
                    } else {
                        System.out.println("Author not found");
                    }
                }
                case 3 -> {
                    System.out.println("----------------Fetch all authors----------------");
                    List<Author> authors = authorController.fetchAllAuthors();
                    if (authors != null && !authors.isEmpty()) {
                        authors.forEach(System.out::println);
                    } else {
                        System.out.println("No authors found");
                    }
                }
                case 4 -> {
                    System.out.println("----------------Update existing author----------------");
                    System.out.println("Enter id of the author to update :");
                    long authorId = in.nextLong();
                    Author updateAuthor = authorController.findAuthorById(authorId);
                    if (updateAuthor == null) {
                        System.out.println("Author not found");
                        continue;
                    }
                    System.out.println("Author details:");
                    System.out.println(updateAuthor);
                    System.out.println("----------------Enter new author details----------------");
                    in.nextLine();
                    System.out.println("Enter name to update: ");
                    String name = in.nextLine();
                    System.out.println("Enter country to update: ");
                    String country = in.nextLine();

                    updateAuthor.setName(name);
                    updateAuthor.setCountry(country);

                    try {
                        updateAuthor = authorController.updateAuthor(updateAuthor);
                        System.out.println("Author updated successfully: " + updateAuthor);
                    } catch (Exception e) {
                        System.out.println("Failed to update author: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("----------------Delete author----------------");
                    System.out.println("Enter author id to delete:");
                    long id = in.nextLong();
                    try {
                        authorController.deleteAuthor(id);
                        System.out.println("Author deleted successfully");
                    } catch (Exception e) {
                        System.out.println("Failed to delete author: " + e.getMessage());
                    }
                }
            }

        }
    }
}
