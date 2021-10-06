package test1.flywayTesting.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import test1.flywayTesting.entities.Book;


public interface BooksRepo extends JpaRepository<Book, Long>, QueryByExampleExecutor<Book> {
}