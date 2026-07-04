package com.library.service;

import com.library.DAO.BookDAO;
import com.library.DAO.Impl.BookDAOImpl;
import com.library.model.Book;

import java.util.List;

public class BookService {

    BookDAO bookDAO = new BookDAOImpl();

    public Book addBook(Book book) {
        return bookDAO.addBook(book);
    }

    public Book findBookById(long id) {
        return bookDAO.findBookById(id);
    }

    public List<Book> fetchAllBooks() {
        return bookDAO.fetchAllBooks();
    }

    public Book updateBook(Book updateBook) {
        return bookDAO.updateBook(updateBook);
    }
}
