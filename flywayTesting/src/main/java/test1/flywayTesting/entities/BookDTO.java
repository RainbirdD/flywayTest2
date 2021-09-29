package test1.flywayTesting.entities;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class BookDTO {

    @NotEmpty
    @Size(min = 2, message = "Author must have name")
    private String author;

    @NotEmpty
    @Size(min = 2, message = "Title must have > 2 letters")
    private String title;

}