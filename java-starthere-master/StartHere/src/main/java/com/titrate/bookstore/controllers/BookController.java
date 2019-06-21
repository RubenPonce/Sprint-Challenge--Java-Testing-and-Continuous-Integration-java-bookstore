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
    public ResponseEntity<?> updateBookInfo(@PathVariable long id, @Valid @RequestBody Book book){
        bookService.update(book, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/data/books/{bookid},authors/{authorid}")
    public ResponseEntity<?> assignBookToAuthor(@PathVariable long authorid,@PathVariable long bookid, @Valid @RequestBody Book newBook){


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/data/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
