package com.example.springdatawebapp.bootstrap;

import com.example.springdatawebapp.domain.Author;
import com.example.springdatawebapp.domain.Book;
import com.example.springdatawebapp.domain.Publisher;
import com.example.springdatawebapp.repositories.AuthorRepository;
import com.example.springdatawebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final Publisher publisher;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, Publisher publisher) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisher = publisher;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("dlfdf", "dfgk");
        Book book = new Book("Some name", "28734");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        System.out.println("Hi!");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
