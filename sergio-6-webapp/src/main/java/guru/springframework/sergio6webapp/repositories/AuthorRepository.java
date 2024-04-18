package guru.springframework.sergio6webapp.repositories;

import guru.springframework.sergio6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
