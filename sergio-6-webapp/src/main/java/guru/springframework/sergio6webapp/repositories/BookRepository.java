package guru.springframework.sergio6webapp.repositories;

import guru.springframework.sergio6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
