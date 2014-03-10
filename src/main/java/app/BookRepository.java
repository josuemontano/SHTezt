package app;

import java.util.List;

/**
 *
 * @author josuemontano
 */
public interface BookRepository {
    
    public List<Book> findAll();
    
}
