package com.titrate.bookstore.repository;

import com.titrate.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository  extends PagingAndSortingRepository<Book, Long> {
}
