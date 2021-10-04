package test1.flywayTesting.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import test1.flywayTesting.entities.Book;

import java.util.Optional;


public interface BooksRepo extends JpaRepository<Book, Long> {

    @Query("select qd from Book qd where qd.author = :#{#req. author} and qd.title = :#{#req.title}")
    Optional<Book> findBook(@Param("req") Book req);


}
