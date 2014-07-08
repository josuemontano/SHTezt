package com.hanovit.app.book.repositories;

import com.hanovit.app.book.entities.Book;
import java.util.List;

/**
 *
 * @author Josue Montano
 */
public interface IBookRepository {
    
    public List<Book> findAll();
    public Book find(int id);
    public Book save(Book book);
    public boolean delete(int id);
    
}
