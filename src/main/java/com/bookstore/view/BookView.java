package com.bookstore.view;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import io.dropwizard.views.View;
import org.eclipse.jetty.security.LoginService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by iurii on 10/5/17.
 */
public class BookView extends View {
    BookService bookService;

    @Inject
    public BookView(BookService bookService) {
        super("/book-view.mustache"); this.bookService = bookService;
    }

    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }
}
