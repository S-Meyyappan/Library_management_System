package com.library.controller;

import com.library.enums.BookStatus;
import com.library.model.Book;
import com.library.service.BookService;

public class BookController {

    BookService bookService = new BookService();

    public Book addBook(Book book) {
        book.setStatus(BookStatus.AVAILABLE);
        return bookService.addBook(book);
    }
}
