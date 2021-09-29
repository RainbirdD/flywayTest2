package test1.flywayTesting.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test1.flywayTesting.mappers.bookMapper;
import test1.flywayTesting.repos.BooksRepo;
import test1.flywayTesting.tables.book;
import test1.flywayTesting.tables.bookDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BooksRepo booksRepo;
    private final bookMapper mapper;



    public List<bookDTO> all() {
        List<book> booksEntityList = (List<book>) booksRepo.findAll();
        List<bookDTO> bookDTOList = mapper.entityListToDtoList(booksEntityList);
        return bookDTOList;
//        return (List<book>) booksRepo.findAll();
    }
}
