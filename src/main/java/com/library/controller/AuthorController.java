package com.library.controller;

import com.library.model.Author;
import com.library.service.AuthorService;

public class AuthorController {

    AuthorService authorService = new AuthorService();

    public Author addAuthor(Author author) {
        return authorService.addAuthor(author);
    }
}
