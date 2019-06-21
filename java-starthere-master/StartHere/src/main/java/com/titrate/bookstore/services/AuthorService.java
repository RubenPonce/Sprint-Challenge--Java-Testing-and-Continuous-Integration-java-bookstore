package com.titrate.bookstore.services;

import com.titrate.bookstore.models.Author;

import java.util.List;

public interface AuthorService{
    List<Author> findAll();
}
