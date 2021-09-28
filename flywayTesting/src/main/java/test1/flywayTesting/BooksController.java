package test1.flywayTesting;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.tables.book;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BooksController {
    private final BooksRepo booksRepo;


    @GetMapping("/books")
    List<book> all(){
        return (List<book>) booksRepo.findAll();
    }


}
