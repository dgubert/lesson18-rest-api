package api;

import io.qameta.allure.Step;
import models.AddListOfBooksRequestModel;
import models.IsbnModel;
import models.UserListOfBooksResponseModel;

import java.util.List;

import static extensions.LoginExtension.response;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.RequestSpec.requestSpec;
import static specs.ResponseSpec.*;

public class BookStoreApi {

    @Step("Удаляем через API книги из корзины")
    public static void deleteAllBooks() {
        given()
            .spec(requestSpec)
            .header("Authorization", "Bearer " + response.getToken())
            .queryParam("UserId", response.getUserId())
        .when()
            .delete("/BookStore/v1/Books")
        .then()
            .spec(response204Spec)
            .extract().response();
    }

    @Step("Добавляем через API указанную книгу в корзину")
    public static void addBookToCart(String isbn) {
        IsbnModel isbnModel = new IsbnModel(isbn);
        AddListOfBooksRequestModel addListOfBooksRequestModel = new AddListOfBooksRequestModel(response.getUserId(), List.of(isbnModel));

        given()
            .spec(requestSpec)
            .header("Authorization", "Bearer " + response.getToken())
            .body(addListOfBooksRequestModel)
        .when()
            .post("/BookStore/v1/Books")
        .then()
            .spec(response201Spec);
    }

    public static UserListOfBooksResponseModel getListOfBooks() {
        return given(requestSpec)
                .header("Authorization", "Bearer " + response.getToken())
            .when()
                .get("/Account/v1/User/" + response.getUserId())
            .then()
                .spec(response200Spec)
                .extract().as(UserListOfBooksResponseModel.class);
    }

    @Step("Проверяем через API отсутствие книг в корзине")
    public static void checkBooksListIsEmpty() {
        UserListOfBooksResponseModel userListOfBooks = getListOfBooks();
        assertThat(userListOfBooks.getBooks()).isEmpty();
    }
}
