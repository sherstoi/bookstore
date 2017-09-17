package com.bookstore.service;

import com.bookstore.dao.AuthorDAO;
import com.bookstore.model.Author;

import java.util.List;

/**
 * Created by iurii on 9/14/17.
 */
public class AuthorService {
    private AuthorDAO authorDAO;

    public AuthorService(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public Author saveAuthor(Author author) {
        return authorDAO.save(author);
    }

    public Author findAuthorById(Integer authorId) {
        return authorDAO.findAuthorById(authorId);
    }

    public List<Author> findAuthorByName(String authorName) {
        return authorDAO.findAuthorByName(authorName);
    }

    public List<Author> findAllAuthors() { return authorDAO.findAllAuthors(); }

    public void deleteAuthor(Author author) {
        authorDAO.deleteAuthor(author);
    }
}
