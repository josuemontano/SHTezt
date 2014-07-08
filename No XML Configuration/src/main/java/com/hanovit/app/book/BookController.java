package com.hanovit.app.book;

import com.hanovit.app.book.entities.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Josue Montano
 */
@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    BookService bookService;
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Book> list() {
        return this.bookService.findAll();
    }
    
    @RequestMapping(value= "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> find(@PathVariable("id") String title) {
        Book book = this.bookService.find(title);
        if (book == null) return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        else              return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> update(@PathVariable("id") String title, @RequestBody Book book) {
        //book.setTitle(title);
        Book uBook = this.bookService.save(book);
        if (uBook == null) return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Book>(HttpStatus.OK);
        //return new ResponseEntity<Book>(HttpStatus.FORBIDDEN);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> delete(@PathVariable("id") String title) {
        if (this.bookService.delete(title)) return new ResponseEntity<Book>(HttpStatus.OK);
        return new ResponseEntity<Book>(HttpStatus.FORBIDDEN);
    }
    
}
