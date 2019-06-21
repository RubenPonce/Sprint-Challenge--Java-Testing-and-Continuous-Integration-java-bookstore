package com.titrate.bookstore.controllers;

import com.titrate.bookstore.models.Book;
import com.titrate.bookstore.models.Role;
import com.titrate.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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

    @PostMapping(value = "/data/books/authors/{id}")
    public ResponseEntity<?> assignBookToAuthor(@PathVariable long id,@Valid @RequestBody Book newBook){
        newBook = bookService.save(newBook);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRoleURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        responseHeaders.setLocation(newRoleURI);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
