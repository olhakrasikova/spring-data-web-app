package com.example.springdatawebapp.repositories;

import com.example.springdatawebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
