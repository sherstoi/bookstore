package com.bookstore.dao;

import com.bookstore.model.Author;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by iurii on 9/13/17.
 */
@SuppressWarnings("unchecked")
public class AuthorDAO extends AbstractDAO<Author> {
    public AuthorDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Author save(Author author) {
        return persist(author);
    }

    public Author findAuthorById(Integer id) {
        return get(id);
    }

    public List<Author> findAuthorByName(String authorName) {
        Query query = currentSession().createQuery("FROM Author a WHERE a.name = :authorName");
        query.setParameter("authorName", authorName);
        return (List<Author>) list(query);
    }

    public List<Author> findAllAuthors() {
        CriteriaQuery<Author> query = currentSession().getCriteriaBuilder().createQuery(Author.class);
        Root<Author> authorRoot = query.from(Author.class);
        TypedQuery<Author> allQuery = currentSession().createQuery(query.select(authorRoot));
        return allQuery.getResultList();
    }

    public void deleteAuthor(Author author) {
        currentSession().delete(author);
    }
}
