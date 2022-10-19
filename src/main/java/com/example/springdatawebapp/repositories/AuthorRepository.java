package com.example.springdatawebapp.repositories;

import com.example.springdatawebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
