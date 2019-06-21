package com.titrate.bookstore.repository;

import com.titrate.bookstore.models.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long>
{

}
