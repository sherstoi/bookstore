package com.bookstore.dao;

import com.bookstore.model.Book;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by iurii on 9/14/17.
 */
@SuppressWarnings("unchecked")
public class BookDAO extends AbstractDAO<Book> {
    public BookDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Book save(Book book) {
        return persist(book);
    }

    public Book findBookByIsbn(String isbn) {
        return get(isbn);
    }

    public List<Book> findBookByTitle(String title) {
        Query query = currentSession().createQuery("FROM Book b WHERE b.title = :title");
        query.setParameter("title", title);
        return (List<Book>) list(query);
    }

    public List<Book> findAllBooks() {
        CriteriaQuery<Book> query = currentSession().getCriteriaBuilder().createQuery(Book.class);
        Root<Book> bookRoot = query.from(Book.class);
        TypedQuery<Book> allQuery = currentSession().createQuery(query.select(bookRoot));
        return allQuery.getResultList();
    }

    public void deleteBook(Book book) {
        currentSession().delete(book);
    }
}
