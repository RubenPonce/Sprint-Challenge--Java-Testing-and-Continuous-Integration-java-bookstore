package com.titrate.bookstore.services;

import com.titrate.bookstore.models.Book;
import com.titrate.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookrepos;

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book findBookById(long id) {
        return bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public Book update(Book book, long id) {
        Book currentBook = bookrepos.findById(id).orElseThrow(EntityNotFoundException::new);
        if(book.getBooktitle() != null){
            currentBook.setBooktitle(book.getBooktitle());
        }
        if(book.getPublishDate() > 0){
            currentBook.setPublishDate(book.getPublishDate());
        }
        if (book.getIsbn() != null){
            currentBook.setIsbn(book.getIsbn());
        }
        if (book.getAuthors() != null && book.getAuthors().size() > 0){
            currentBook.setAuthors(book.getAuthors());
        }

        bookrepos.save(currentBook);
        return currentBook;
    }



    @Override
    public void delete(long id) {
//        if (bookrepos.findById(id).isPresent())
//        {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            if (bookrepos.findById(id).get().getAuthor()().equalsIgnoreCase(authentication.getName()))
//            {
//                bookrepos.deleteById(id);
//            }
//            else
//            {
//                throw new EntityNotFoundException(Long.toString(id) + " " + authentication.getName());
//            }
//        }
//        else
//        {
//            throw new EntityNotFoundException(Long.toString(id));
//        }

    }

    @Transactional
    @Override
    public Book save(Book book) {
        return bookrepos.save(book);
    }
}
