package models;

import lombok.Data;

import java.util.List;

@Data
public class ListOfBooksResponseModel {
    String userId,
            username;
    List<BookModel> books;
}