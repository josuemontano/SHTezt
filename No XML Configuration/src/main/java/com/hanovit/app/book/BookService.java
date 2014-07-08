package com.hanovit.app.book;

import com.hanovit.app.book.entities.Book;
import com.hanovit.app.book.repositories.IBookRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue Montano
 */
@Service("bookService")
public class BookService {

    @Autowired
    IBookRepository bookRepository;

    @Transactional
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Transactional
    public Book find(int id) {
        return this.bookRepository.find(id);
    }
    
    @Transactional
    public Book save(Book book) {
        return this.bookRepository.save(book);
    }
    
    @Transactional
    public boolean delete(int id) {
        return this.bookRepository.delete(id);
    }

}
