package test1.flywayTesting.mappers;


import org.mapstruct.Mapper;
import test1.flywayTesting.entities.Book;
import test1.flywayTesting.entities.BookDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface bookMapper {

    Book dtoToEntity(BookDTO dto);


    BookDTO entityToDto(Book entity);

    List<BookDTO> entityListToDtoList(List<Book> entityList);

    List<Book> dtoListToEntityList(List<BookDTO> dtoList);

}
