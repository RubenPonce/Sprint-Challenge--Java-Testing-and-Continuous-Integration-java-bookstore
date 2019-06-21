package com.titrate.bookstore.services;

import com.titrate.bookstore.exceptions.ResourceNotFoundException;
import com.titrate.bookstore.models.Author;
import com.titrate.bookstore.models.Book;
import com.titrate.bookstore.repository.AuthorRepository;
import com.titrate.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    @Autowired
    AuthorRepository authorrepos;

    @Override
    public List<Book> findAll(Pageable pageable) {
        List<Book> list = new ArrayList<>();
        bookrepos.findAll(pageable).iterator().forEachRemaining(list::add);
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
        if (bookrepos.findById(id).isPresent()){
            bookrepos.deleteById(id);
        }else{
            throw new EntityNotFoundException();
        }

    }

    @Transactional
    @Override
    public Book save(Book book) {
        return bookrepos.save(book);
    }
    @Override
    public void setBookAuthor(long bookid, long authorid) {
        Book currentBook = bookrepos.findById(bookid).orElseThrow(EntityNotFoundException::new);
        currentBook.getAuthors().add(authorrepos.findById(authorid).orElseThrow(EntityNotFoundException::new));
        bookrepos.save(currentBook);
    }

}
