package com.hanovit.app.book.repositories;

import com.hanovit.app.book.entities.Book;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue Montano
 */
@Repository
public class BookRepository implements IBookRepository {
    
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Book> findAll() {
        Criteria criteria = getCurrentSession().createCriteria(Book.class);
        return criteria.list();
    }

    @Override
    public Book find(int id) {
        return (Book)getCurrentSession().get(Book.class, id);
    }
    
    @Override
    public Book save(Book book) {
        Book bookRef = find(book.getId());
        if (bookRef == null) {
            getCurrentSession().save(book);
            return book;
        } else {
            bookRef.setTitle(book.getTitle());
            getCurrentSession().update(bookRef);
            return bookRef;
        }
    }
    
    @Override
    public boolean delete(int id) {
        Book bookRef = find(id);
        if (bookRef != null) {
            getCurrentSession().delete(bookRef);
            return true;
        } else {
            return false;
        }
    }
    
}
