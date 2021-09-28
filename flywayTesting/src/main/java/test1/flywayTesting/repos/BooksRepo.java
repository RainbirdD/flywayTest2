package test1.flywayTesting.repos;

import org.springframework.data.repository.CrudRepository;
import test1.flywayTesting.tables.book;

public interface BooksRepo extends CrudRepository<book, Long> {

}
