package com.hanovit.app.book.repositories;

import com.hanovit.app.book.entities.Book;
import java.util.List;

/**
 *
 * @author Josue Montano
 */
public interface IBookRepository {
    
    public List<Book> findAll();
    public Book find(String title);
    public Book save(Book book);
    public boolean delete(String title);
    
}
