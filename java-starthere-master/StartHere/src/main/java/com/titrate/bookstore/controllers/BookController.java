package com.titrate.bookstore.controllers;

import com.titrate.bookstore.models.Book;
import com.titrate.bookstore.models.Role;
import com.titrate.bookstore.services.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @ApiOperation(value = "Gets lists of books", response = Book.class)
    @GetMapping(value = "/books")
    public ResponseEntity<?> listAllBooks(@PageableDefault (page = 0,size = 4) Pageable pageable){
    return new ResponseEntity<>(bookService.findAll(pageable), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_DATA')")
    @ApiOperation(value = "Updates stuff like title", response = void.class)
    @PutMapping(value = "/data/books/{id}")
    public ResponseEntity<?> updateBookInfo(@PathVariable long id, @Valid @RequestBody Book book){
        bookService.update(book, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_DATA')")
    @ApiOperation(value = "Switcharoo's authorinos", response = void.class)
    @PostMapping("/data/books/authors/{bookid}/{authorid}")
    public ResponseEntity<?> setBookAuthor(@PathVariable("bookid") long bookid, @PathVariable("authorid") long authorid) {
        bookService.setBookAuthor(bookid, authorid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_DATA')")
    @ApiOperation(value = "Delete book", response = void.class)
    @DeleteMapping(value = "/data/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
