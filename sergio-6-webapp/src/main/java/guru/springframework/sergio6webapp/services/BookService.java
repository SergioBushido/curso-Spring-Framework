package guru.springframework.sergio6webapp.services;

import guru.springframework.sergio6webapp.domain.Book;

public interface BookService {

    Iterable<Book>findAll();
}
