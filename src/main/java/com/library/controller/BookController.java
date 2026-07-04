package com.library.controller;

import com.library.enums.BookStatus;
import com.library.model.Book;
import com.library.service.BookService;

import java.util.List;

public class BookController {

    BookService bookService = new BookService();

    public Book addBook(Book book) {
        book.setStatus(BookStatus.AVAILABLE);
        return bookService.addBook(book);
    }

    public Book findBookById(long id) {
        return bookService.findBookById(id);
    }

    public List<Book> fetchAllBooks() {
        return bookService.fetchAllBooks();
    }

    public Book updateBook(Book updateBook) {
        return bookService.updateBook(updateBook);
    }
}
