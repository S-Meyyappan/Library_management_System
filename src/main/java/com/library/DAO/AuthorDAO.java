package com.library.DAO;

import com.library.model.Author;

import java.util.List;

public interface AuthorDAO {
    Author addAuthor(Author author);

    Author findAuthorById(long id);

    List<Author> fetchAllAuthors();
}
