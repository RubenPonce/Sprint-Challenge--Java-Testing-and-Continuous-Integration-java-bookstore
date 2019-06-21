package com.titrate.bookstore.repository;

import com.titrate.bookstore.models.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BookRepository  extends PagingAndSortingRepository<Book, Long> {
    @Modifying
    @Query(value = "DELETE FROM WROTE WHERE  bookid =:bookid ", nativeQuery = true)
    void deleteStuff(long bookid);
}
