package com.library.DAO;

import com.library.enums.BookStatus;
import com.library.enums.Genre;
import com.library.model.Book;

import java.util.List;

public interface BookDAO {
    Book addBook(Book book);

    Book findBookById(long id);

    List<Book> fetchAllBooks();

    Book updateBook(Book updateBook);

    void deleteBook(long id);

    List<Book> getBooksByAuthor(long authorId);

    List<Book> getBooksByBorrower(long borrowerId);

    List<Book> getBooksByGenreAndStatus(Genre genre, BookStatus bookStatus);
}
