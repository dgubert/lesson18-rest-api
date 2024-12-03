package models;

import lombok.Data;

import java.util.List;

@Data
public class ListOfBooksResponseModel {
    List<BookModel> books;
}