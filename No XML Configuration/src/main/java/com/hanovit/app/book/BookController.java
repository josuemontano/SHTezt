package com.hanovit.app.book;

import com.hanovit.app.book.entities.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author josuemontano
 */
@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    BookService bookService;
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Book> list() {
        return this.bookService.findAll();
    }
    
    @RequestMapping(value= "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Book find(@RequestParam("id") String title) {
        return this.bookService.find(title);
    }
    
}
