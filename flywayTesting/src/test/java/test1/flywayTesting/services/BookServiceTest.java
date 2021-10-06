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

//        BookDTO bookDTO2 = new BookDTO();
//        bookDTO2.setAuthor("NormalAuthor");
//        bookDTO2.setTitle("NormalTitle");
//
//        Book book2 = new Book();
//        book2.setTitle("NormalAuthor");
//        book2.setAuthor("NormalTitle");

//        Assertions.assertThrows(BookAlreadyExistException.class, () -> {
//            bookService.createBook(bookDTO);
//        });

        when(bookService.isExistByAuthorAndTitle(any(Book.class))).thenReturn(true);
        when(booksRepo.save(any(Book.class))).thenAnswer(i -> i.getArguments()[0]);
        bookService.createBook(bookDTO);






//        bookService.createBook(bookDTO2);




//        ResponseEntity<BookDTO> bookDTO1 = bookService.createBook(bookDTO);
//
//        System.out.println(bookDTO1);
//        System.out.println(booksRepo.findAll());
//        Book book = new Book();
//        book.setTitle("NormalAuthor");
//        book.setAuthor("NormalTitle");


//        System.out.println("Example entity: "+book);
//        Example<Book> bookExample = Example.of(book, ExampleMatcher.matching().withIgnorePaths("ID"));
//        Iterable<Book> books = booksRepo.findAll(bookExample);



    }
}