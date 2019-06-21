package com.titrate.bookstore.repository;

import com.titrate.bookstore.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
//    ArrayList<Author> findAuthorsByLastnameLike (String name);
}
