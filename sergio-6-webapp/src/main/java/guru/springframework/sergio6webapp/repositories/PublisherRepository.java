package guru.springframework.sergio6webapp.repositories;

import guru.springframework.sergio6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
