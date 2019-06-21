package com.titrate.bookstore.controllers;

import com.titrate.bookstore.services.AuthorService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @GetMapping(value = "/authors")
    public ResponseEntity<?> listAllAuthors(){
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }
}
