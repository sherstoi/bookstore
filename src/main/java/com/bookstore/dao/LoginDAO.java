package com.bookstore.dao;

import com.bookstore.model.Logins;
import io.dropwizard.hibernate.AbstractDAO;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by iurii on 10/25/17.
 */
@SuppressWarnings("unchecked")
public class LoginDAO extends AbstractDAO<Logins> {
    public LoginDAO(SessionFactory sessionFactory) {super(sessionFactory);}

    public boolean isUserExists(String login, String password) {
        Query query = currentSession().createQuery("FROM Logins l WHERE l.login = :login AND l.pwd = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);

        return CollectionUtils.isNotEmpty((List<Logins>) list(query));
    }
}
