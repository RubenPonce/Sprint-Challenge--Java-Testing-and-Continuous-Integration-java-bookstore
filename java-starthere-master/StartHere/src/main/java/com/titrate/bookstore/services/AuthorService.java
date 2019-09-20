package com.titrate.bookstore.services;

import com.titrate.bookstore.models.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService{
    List<Author> findAll(Pageable pageable);
}
