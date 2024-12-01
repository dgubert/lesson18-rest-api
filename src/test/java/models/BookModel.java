package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookModel {
    public String userId;
    List<IsbnModel> collectionOfIsbns;
}
