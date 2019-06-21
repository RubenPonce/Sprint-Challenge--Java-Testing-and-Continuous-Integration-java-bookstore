package com.titrate.bookstore.controllers;

import com.titrate.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping(value = "/books")
    public ResponseEntity<?> listAllBooks(){
    return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/data/books/{id}")
    public ResponseEntity<?> updateBookInfo(@PathVariable long id){
        bookService.update(bookService.findBookById(id), id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
