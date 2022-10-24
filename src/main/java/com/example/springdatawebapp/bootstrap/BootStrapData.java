package com.example.springdatawebapp.bootstrap;

import com.example.springdatawebapp.domain.Author;
import com.example.springdatawebapp.domain.Book;
import com.example.springdatawebapp.domain.Publisher;
import com.example.springdatawebapp.repositories.AuthorRepository;
import com.example.springdatawebapp.repositories.BookRepository;
import com.example.springdatawebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("oeif");
        publisher.setCity("city");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author author = new Author("dlfdf", "dfgk");
        Book book = new Book("Some name", "28734");

        author.getBooks().add(book);
        book.getAuthors().add(author);

        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        System.out.println("Hi!");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of book from Publisher : " + publisher.getBooks().size());
    }
}
