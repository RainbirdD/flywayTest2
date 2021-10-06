package test1.flywayTesting.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test1.flywayTesting.entities.BookDTO;
import test1.flywayTesting.services.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @GetMapping("books")
    public List<BookDTO> getBooks() {
        return bookService.all();
    }

    @PostMapping("books")
    void createBooks(@Valid @RequestBody BookDTO bookDTO) throws Exception {
        bookService.createBook(bookDTO);
    }



}
