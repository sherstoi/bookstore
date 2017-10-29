package com.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by iurii on 10/25/17.
 */
@Entity
@Table(name = "logins")
public class Logins {
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "pwd")
    private String pwd;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
