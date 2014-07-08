package com.hanovit.app.book;

import com.hanovit.app.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Book> find(@PathVariable("id") int id) {
        Book book = this.bookService.find(id);
        if (book == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else              return new ResponseEntity<>(book, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> update(@PathVariable("id") int id, @RequestBody Book book) {
        //book.setTitle(title);
        Book uBook = this.bookService.save(book);
        if (uBook == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else               return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> delete(@PathVariable("id") int id) {
        if (this.bookService.delete(id)) return new ResponseEntity<>(HttpStatus.OK);
        else                             return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    
}
