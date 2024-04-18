package guru.springframework.sergio6webapp.bootstrap;

import guru.springframework.sergio6webapp.domain.Author;
import guru.springframework.sergio6webapp.domain.Book;
import guru.springframework.sergio6webapp.domain.Publisher;
import guru.springframework.sergio6webapp.repositories.AuthorRepository;
import guru.springframework.sergio6webapp.repositories.BookRepository;
import guru.springframework.sergio6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Creating the author
        Author eric = new Author();
        eric.setFirstname("Eric");
        eric.setLastaname("Evans");

        // Creating books
        Book ddd = new Book();
        ddd.setTitle("Domain-Driven Design");
        ddd.setIsbn("123456");

        Book lotr = new Book();
        lotr.setTitle("The Lord of the Rings");
        lotr.setIsbn("654321");

        // Associate books with Eric
        eric.getBooks().add(ddd);
        eric.getBooks().add(lotr);
        ddd.getAuthors().add(eric);
        lotr.getAuthors().add(eric);

        // Creating the publisher
        Publisher publisher = new Publisher();
        publisher.setPublisherName("Random House");
        publisher.setAddress("Main Street, Anytown");

        // Saving the publisher
        publisherRepository.save(publisher);

        // Setting the publisher for the books
        ddd.setPublisher(publisher);
        lotr.setPublisher(publisher);

        // Save everything to the database
        authorRepository.save(eric);
        bookRepository.save(ddd);
        bookRepository.save(lotr);

        System.out.println("Loaded Bootstrap Data");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
