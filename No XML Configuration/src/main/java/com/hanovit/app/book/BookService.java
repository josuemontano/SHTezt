package com.hanovit.app.book;

import com.hanovit.app.book.entities.Book;
import com.hanovit.app.book.repositories.IBookRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josuemontano
 */
@Service("bookService")
public class BookService {

    @Autowired
    IBookRepository bookRepository;

    @Transactional
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    public Book find(String title) {
        return this.bookRepository.find(title);
    }
    
    public Book save(Book book) {
        return this.bookRepository.save(book);
    }
    
    public boolean delete(String title) {
        return this.bookRepository.delete(title);
    }

}
