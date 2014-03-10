package app;

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
    BookRepository bookRepository;

    @Transactional
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

}