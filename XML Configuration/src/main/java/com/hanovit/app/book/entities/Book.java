package com.hanovit.app.book.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author josuemontano
 */
@Entity
@Table(name = "Books")
public class Book implements Serializable {
    
    @Id
    @Column(name = "Title")
    private String title;
    
    @Column(name = "ISBN")
    private String ISBN;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
}
