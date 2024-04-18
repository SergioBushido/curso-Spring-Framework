package guru.springframework.sergio6webapp.services;

import guru.springframework.sergio6webapp.domain.Author;
import guru.springframework.sergio6webapp.domain.Book;

public interface AuthorService {
    Iterable<Author>findAll();
}
