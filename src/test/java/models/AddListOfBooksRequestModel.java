package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class AddListOfBooksRequestModel {
    String userId;
    List<IsbnModel> collectionOfIsbns;
}
