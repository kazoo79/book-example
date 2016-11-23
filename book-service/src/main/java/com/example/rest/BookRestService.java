package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.repository.BookRepository;
import com.example.repository.resource.Book;

import java.util.List;

/**
 * Created by pdebala on 2016-10-07.
 */
@RestController
@RequestMapping(value = "/books")
public class BookRestService {

    private final BookRepository bookRepository;

    @Autowired
    public BookRestService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("id") Long id) {
        return bookRepository.findOne(id);
    }
}
