package com.titrate.bookstore.controllers;

import com.titrate.bookstore.models.Author;
import com.titrate.bookstore.services.AuthorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @ApiOperation(value = "Gets lists of authors", response = Author.class)
    @GetMapping(value = "/authors")
    public ResponseEntity<?> listAllAuthors(@PageableDefault(page = 0,size = 4) Pageable pageable){
        return new ResponseEntity<>(authorService.findAll(pageable), HttpStatus.OK);
    }
}
