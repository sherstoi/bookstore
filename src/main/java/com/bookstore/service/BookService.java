package com.bookstore.service;

import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by iurii on 9/14/17.
 */
public class BookService {

    private BookDAO bookDAO;

    @Inject
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Book saveBook(Book book) {
        return bookDAO.save(book);
    }

    public Book findBookByIsbn(String isbn) {
        return bookDAO.findBookByIsbn(isbn);
    }

    public List<Book> findBookByTitle(String title) {
        return bookDAO.findBookByTitle(title);
    }

    public List<Book> findAllBooks() {
        return bookDAO.findAllBooks();
    }

    public void deleteBook(Book book) {
        bookDAO.deleteBook(book);
    }
}