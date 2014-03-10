package app;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josuemontano
 */
@Repository("bookRepository")
public class DummyBookRepository implements BookRepository {
    
    //@Resource(name = "sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<Book> findAll() {
        Criteria criteria = getCurrentSession().createCriteria(Book.class);
        return criteria.list();
    }
    
}
