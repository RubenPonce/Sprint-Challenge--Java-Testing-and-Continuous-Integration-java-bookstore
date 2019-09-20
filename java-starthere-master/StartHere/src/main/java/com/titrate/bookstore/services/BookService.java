package com.titrate.bookstore.services;

import com.titrate.bookstore.models.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    List<Book> findAll(Pageable pageable);

    Book findBookById(long id);

//    List<Book> findByUserName(String username);

    void delete(long id);

    Book save(Book book);
    Book update( Book book, long id);
    void setBookAuthor(long bookid, long authorid);

}
