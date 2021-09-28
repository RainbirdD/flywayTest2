package test1.flywayTesting;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.tables.book;

import java.util.List;

@RestController
public class BooksController {

    private BooksRepo booksRepo;

    BooksController(BooksRepo booksRepo){
        this.booksRepo=booksRepo;
    }

    @GetMapping("/books")
    List<book> all(){
        return (List<book>) booksRepo.findAll();
    }




}
