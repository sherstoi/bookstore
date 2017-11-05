package com.bookstore.dao;

import com.bookstore.model.Usrlog;
import io.dropwizard.hibernate.AbstractDAO;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by iurii on 10/25/17.
 */
@SuppressWarnings("unchecked")
public class LoginDAO extends AbstractDAO<Usrlog> {
    public LoginDAO(SessionFactory sessionFactory) {super(sessionFactory);}

    public boolean isUserExists(String login, String password) {
        Query query = currentSession().createQuery("FROM Usrlog WHERE log = :login AND pwd = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);

        return CollectionUtils.isNotEmpty((List<Usrlog>) list(query));
    }
}
