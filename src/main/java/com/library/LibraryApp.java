package com.library;

import com.library.config.HbmConfig;
import com.library.controller.BookController;
import com.library.enums.Genre;
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

        while (true){
            System.out.println("1. Add a new book");
            System.out.println("2. Find book by Id");
            System.out.println("3. Fetch all books");
            System.out.println("4. Update existing book");
            System.out.println("5. Delete a book");
            System.out.println("0. Exit");

            System.out.println("Enter your choice: ");
            int choice = in.nextInt();

            if(choice == 0){
                System.out.println("Exiting...");
                break;
            }

            switch (choice){
                case 1 -> {
                    System.out.println("----------------Enter book details----------------");
                    in.nextLine();
                    System.out.println("Enter book title: ");
                    String title = in.nextLine();
                    System.out.println("Choose genre:");
                    Arrays.stream(Genre.values()).forEach(System.out::println);
                    String genre = in.nextLine();
                    System.out.println("Enter author name: ");
                    String authorName = in.nextLine();
                    System.out.println("Enter Author Country");
                    String authorCountry = in.nextLine();
                    System.out.println("Enter publication year: ");
                    int publicationYear = in.nextInt();

                    Author author = new Author();
                    author.setName(authorName);
                    author.setCountry(authorCountry);

                    Book book = new Book();
                    book.setTitle(title);
                    book.setGenre(Genre.valueOf(genre));
                    book.setAuthor(author);
                    book.setPublicationYear(publicationYear);

                    try {
                        book = bookController.addBook(book);
                        System.out.println("Book added successfully: " + book);
                    } catch (Exception e) {
                        System.out.println("Failed to add book: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("----------------Find book by Id----------------");
                    System.out.println("Enter book Id :");
                    long id = in.nextLong();
                    Book book = bookController.findBookById(id);
                    if (book != null) {
                        System.out.println("Book found: " + book);
                    } else {
                        System.out.println("Book not found");
                    }
                }
                case 3 -> {
                    System.out.println("----------------Fetch all books----------------");
                    List<Book> books = bookController.fetchAllBooks();
                    if (books != null && !books.isEmpty()) {
                        books.forEach(System.out::println);
                    } else {
                        System.out.println("No books found");
                    }
                }
            }

        }
    }
}
