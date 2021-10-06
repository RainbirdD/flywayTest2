package test1.flywayTesting.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import test1.flywayTesting.entities.Book;
import test1.flywayTesting.entities.BookDTO;
import test1.flywayTesting.exceptions.BookAlreadyExistException;
import test1.flywayTesting.repos.BooksRepo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BooksRepo booksRepo;

    @Test
    void createBook() throws Exception {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthor("NormalAuthor");
        bookDTO.setTitle("NormalTitle");


//        Assertions.assertThrows(BookAlreadyExistException.class, () -> {
//            bookService.createBook(bookDTO);
//        });
//        when(bookService.isExistByAuthorAndTitle(any(Book.class))).thenReturn(false);
        when(booksRepo.save(any(Book.class))).thenAnswer(i -> i.getArguments()[0]);
        bookService.createBook(bookDTO);
//        ResponseEntity<BookDTO> bookDTO1 = bookService.createBook(bookDTO);

    }
}