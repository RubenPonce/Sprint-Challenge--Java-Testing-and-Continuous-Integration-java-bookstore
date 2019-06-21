package com.titrate.bookstore.repository;

import com.titrate.bookstore.models.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    ArrayList<Author> findAuthorsByLastNameLike (String name);
}
