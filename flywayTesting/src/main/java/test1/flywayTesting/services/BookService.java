package test1.flywayTesting.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test1.flywayTesting.exceptions.BookAlreadyExistException;
import test1.flywayTesting.mappers.BookMapper;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.entities.Book;
import test1.flywayTesting.entities.BookDTO;

import java.util.List;

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





    public boolean isExistByAuthorAndTitle(Book book) {

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id");
        Example<Book> bookExample = Example.of(book, exampleMatcher);
        booksRepo.findAll(bookExample).forEach(System.out::println);

        if (booksRepo.findAll(bookExample).isEmpty()){
            return true;
        }else return false;
    }












    public ResponseEntity<BookDTO> createBook(BookDTO bookDTO) throws Exception {

        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());

//        Optional<Book> optRecord = booksRepo.findBook(book);
//        Boolean isExist = booksRepo.existsByAuthorAndTitle(book);

        if(isExistByAuthorAndTitle(book) == false){
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
