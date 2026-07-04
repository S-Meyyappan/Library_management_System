package com.library.DAO;

import com.library.model.Book;

import java.util.List;

public interface BookDAO {
    Book addBook(Book book);

    Book findBookById(long id);

    List<Book> fetchAllBooks();

    Book updateBook(Book updateBook);
}
