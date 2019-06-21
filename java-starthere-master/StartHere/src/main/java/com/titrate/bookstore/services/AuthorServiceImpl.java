package com.titrate.bookstore.services;

import com.titrate.bookstore.models.Author;
import com.titrate.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    AuthorRepository authorrepos;
    @Override
    public List<Author> findAll() {
        List<Author> list = new ArrayList<>();
        authorrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
