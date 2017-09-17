package com.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iurii on 9/13/17.
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(sequenceName = "global_seq", name = "GlobalHiberSequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GlobalHiberSequence")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    @JsonBackReference
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
