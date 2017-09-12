package com.bookstore.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Created by iurii on 9/13/17.
 */
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "ISBN", nullable = false)
    private String ISBN;
    @Column(name = "Title", nullable = false)
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "DateOfPublication")
    private Date pubDate;
    @Column(name = "ImageURL")
    private String imageURL;
    @Column(name = "Price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private Author author;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Author getAuthor() { return author; }

    public void setAuthor(Author author) { this.author = author; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }
}
