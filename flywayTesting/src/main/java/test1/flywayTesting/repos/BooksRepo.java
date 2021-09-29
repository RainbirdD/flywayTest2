package test1.flywayTesting.repos;

import org.springframework.data.repository.CrudRepository;
import test1.flywayTesting.entities.Book;

public interface BooksRepo extends CrudRepository<Book, Long> {

}
