package com.library.controller;

import com.library.model.Author;
import com.library.service.AuthorService;

import java.util.List;

public class AuthorController {

    AuthorService authorService = new AuthorService();

    public Author addAuthor(Author author) {
        return authorService.addAuthor(author);
    }

    public Author findAuthorById(long id) {
        return authorService.findAuthorById(id);
    }

    public List<Author> fetchAllAuthors() {
        return authorService.fetchAllAuthors();
    }
}
