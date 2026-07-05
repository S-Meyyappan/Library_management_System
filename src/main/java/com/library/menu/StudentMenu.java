package com.library.menu;

import com.library.controller.BookController;
import com.library.enums.BookStatus;
import com.library.enums.Genre;
import com.library.model.Author;
import com.library.model.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentMenu implements Menu {
    @Override
    public void displayMenu() {
        Scanner in = new Scanner(System.in);

        BookController bookController = new BookController();

        System.out.println("-------------------Student Menu-------------------");
        while (true){
            System.out.println("1. Add a new book");
            System.out.println("2. Find book by Id");
            System.out.println("3. Fetch all books");
            System.out.println("4. Update existing book");
            System.out.println("5. Delete a book");
            System.out.println("0. Go Back");
            System.out.println("----------------------------------------------");

            System.out.println("Enter your choice: ");
            int choice = in.nextInt();

            if(choice == 0){
                System.out.println("Exiting...");
                return;
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
                case 4 -> {
                    System.out.println("----------------Update existing book----------------");
                    System.out.println("Enter id of the book to update :");
                    long bookId = in.nextLong();
                    Book updateBook = bookController.findBookById(bookId);
                    if(updateBook == null){
                        System.out.println("Book not found");
                        continue;
                    }
                    System.out.println("Book details:");
                    System.out.println(updateBook);
                    System.out.println("-----------------Enter new details-----------------");
                    System.out.println("Enter title to update :");
                    in.nextLine();
                    String title = in.nextLine();
                    System.out.println("Enter genre to update :");
                    Arrays.stream(Genre.values()).forEach(System.out::println);
                    String genre = in.nextLine();
                    System.out.println("Enter status to update :");
                    Arrays.stream(BookStatus.values()).forEach(System.out::println);
                    String status = in.nextLine();
                    System.out.println("Enter publishedYear to update :");
                    int publishedYear = in.nextInt();

                    updateBook.setTitle(title);
                    updateBook.setGenre(Genre.valueOf(genre));
                    updateBook.setStatus(BookStatus.valueOf(status));
                    updateBook.setPublicationYear(publishedYear);

                    updateBook = bookController.updateBook(updateBook);
                    System.out.println("Book updated successfully: " + updateBook);
                }
                case 5 -> {
                    System.out.println("----------------Delete book----------------");
                    System.out.println("Enter book id to delete:");
                    long id = in.nextLong();
                    try {
                        bookController.deleteBook(id);
                        System.out.println("Book deleted successfully");
                    } catch (Exception e) {
                        System.out.println("Failed to delete book: " + e.getMessage());
                    }
                }
            }

        }
    }
}
