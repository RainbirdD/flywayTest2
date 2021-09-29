package test1.flywayTesting.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test1.flywayTesting.entities.Book;
import test1.flywayTesting.entities.BookDTO;
import test1.flywayTesting.services.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

//    @GetMapping("/books")
//    List<Book> all(){
//        return (List<Book>) booksRepo.findAll();
//    }

    @GetMapping("books")
    public List<BookDTO> getBooks() {
        return bookService.all();
    }

    @PostMapping("books/add")
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {

        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());

        Book savedBook = bookService.addBook(book);

        BookDTO bookResponse = new BookDTO();
        bookResponse.setAuthor(savedBook.getAuthor());
        bookResponse.setTitle(savedBook.getTitle());

        return new ResponseEntity<BookDTO>(bookResponse, HttpStatus.CREATED);
    }


}
