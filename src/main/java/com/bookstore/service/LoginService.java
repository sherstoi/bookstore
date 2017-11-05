package com.bookstore.service;

import com.bookstore.dao.LoginDAO;

import javax.inject.Inject;

/**
 * Created by iurii on 10/25/17.
 */
public class LoginService {
    private LoginDAO loginDAO;

    @Inject
    public LoginService(LoginDAO loginDAO) { this.loginDAO = loginDAO;}

    public boolean isUserExits(String login, String pwd) {
        return loginDAO.isUserExists(login, pwd);
    }
}
