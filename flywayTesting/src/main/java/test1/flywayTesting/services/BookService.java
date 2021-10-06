package test1.flywayTesting.services;


import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import test1.flywayTesting.exceptions.BookAlreadyExistException;
import test1.flywayTesting.mappers.BookMapper;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.entities.Book;
import test1.flywayTesting.entities.BookDTO;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BooksRepo booksRepo;
    private final BookMapper mapper;

    public List<BookDTO> all() {
        List<Book> booksEntityList = (List<Book>) booksRepo.findAll();
        List<BookDTO> bookDTOList = mapper.entityListToDtoList(booksEntityList);
        return bookDTOList;
    }








    public ResponseEntity<BookDTO> createBook(BookDTO bookDTO) throws Exception {

        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());

//        Optional<Book> optRecord = booksRepo.findBook(book);
        Boolean isExist = booksRepo.existsByAuthorAndTitle(book);

        if(isExist){
            throw new BookAlreadyExistException("The book " + " already exist");
        //            throw new Exception("Book with the given title and author exists");

        }else{
            Book savedBook = booksRepo.save(book);
            BookDTO bookResponse = new BookDTO();
            bookResponse.setAuthor(savedBook.getAuthor());
            bookResponse.setTitle(savedBook.getTitle());

            return new ResponseEntity<BookDTO>(bookResponse, HttpStatus.CREATED);
        }
    }


}
