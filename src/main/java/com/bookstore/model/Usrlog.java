package com.bookstore.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by iurii on 10/25/17.
 */
@Entity
@Table(name = "usrlog")
public class Usrlog implements Serializable {
    @Id
    @Column(name = "log")
    private String log;
    @Column(name = "pwd")
    private String pwd;

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
