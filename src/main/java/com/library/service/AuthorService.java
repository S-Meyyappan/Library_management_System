package com.library.service;

import com.library.DAO.AuthorDAO;
import com.library.DAO.Impl.AuthorDAOImpl;
import com.library.model.Author;

import java.util.List;

public class AuthorService {

    AuthorDAO authorDAO = new AuthorDAOImpl();

    public Author addAuthor(Author author) {
        return authorDAO.addAuthor(author);
    }

    public Author findAuthorById(long id) {
        return authorDAO.findAuthorById(id);
    }

    public List<Author> fetchAllAuthors() {
        return authorDAO.fetchAllAuthors();
    }
}
