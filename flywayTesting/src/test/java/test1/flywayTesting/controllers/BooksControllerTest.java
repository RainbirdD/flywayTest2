package test1.flywayTesting.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test1.flywayTesting.entities.BookDTO;
import test1.flywayTesting.exceptions.BookAlreadyExistException;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.services.BookService;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(JUnit4.class)
@SpringBootTest
class BooksControllerTest {
    @Autowired
    BookService bookService;

    @Autowired
    BooksController booksController;
    @Autowired
    private BooksRepo booksRepo;


    @Test
    void createBooks() throws Exception {

        BookDTO book = new BookDTO();

        book.setAuthor("Yakub Zwiek");
        book.setTitle("Klamca");


        Assertions.assertThrows(BookAlreadyExistException.class, () -> {
            booksController.createBooks(book);
        });


    }
}