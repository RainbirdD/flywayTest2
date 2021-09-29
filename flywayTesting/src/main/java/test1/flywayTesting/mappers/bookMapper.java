package test1.flywayTesting.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import test1.flywayTesting.tables.book;
import test1.flywayTesting.tables.bookDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface bookMapper {

    book dtoToEntity(bookDTO dto);


    bookDTO entityToDto(book entity);

    List<bookDTO> entityListToDtoList(List<book> entityList);

    List<book> dtoListToEntityList(List<bookDTO> dtoList);

}
