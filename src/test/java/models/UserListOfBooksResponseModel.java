package models;

import lombok.Data;

import java.util.List;

@Data
public class UserListOfBooksResponseModel {
    String userId,
            username;
    List<BookModel> books;
}
