package com.titrate.bookstore.repository;

import com.titrate.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book, Long> {
}
