package com.bookstore.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iurii on 9/13/17.
 */
@Entity
@Table(name = "Author")
public class Author {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Book> bookSet = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
