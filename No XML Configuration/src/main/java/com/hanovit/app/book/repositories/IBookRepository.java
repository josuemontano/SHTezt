package com.hanovit.app.book.repositories;

import com.hanovit.app.book.entities.Book;
import java.util.List;

/**
 *
 * @author josuemontano
 */
public interface IBookRepository {
    
    public List<Book> findAll();
    public Book find(String title);
    public Book save(Book book);
    public booelan delete(String title);
    
}
