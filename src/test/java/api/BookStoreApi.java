package api;

import models.BookModel;
import models.IsbnModel;
import models.ListOfBooksResponseModel;

import java.util.List;

import static extensions.LoginExtension.response;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.RequestSpec.requestSpec;
import static specs.ResponseSpec.*;

public class BookStoreApi {

    public static void deleteAllBooks() {
        step("Удаляем через API книгу из корзины", () -> {
            given()
                .spec(requestSpec)
                .header("Authorization", "Bearer " + response.getToken())
                .queryParam("UserId", response.getUserId())
            .when()
                .delete("/BookStore/v1/Books")
            .then()
                .spec(response204Spec)
                .extract().response();});
    }

    public static void addBookToCart(String isbn) {
        IsbnModel isbnModel = new IsbnModel(isbn);
        BookModel bookModel = new BookModel(response.getUserId(), List.of(isbnModel));

        step("Сделать запрос добавления книги в корзину", () -> {
            given()
                .spec(requestSpec)
                .header("Authorization", "Bearer " + response.getToken())
                .body(bookModel)
            .when()
                .post("/BookStore/v1/Books")
            .then()
                .spec(response201Spec);});
    }

    public static ListOfBooksResponseModel getListOfBooks() {
        return given(requestSpec)
                .header("Authorization", "Bearer " + response.getToken())
                .queryParam("UserId", response.getUserId())
                .when()
                .get("/Account/v1/User/" + response.getUserId())
                .then()
                .spec(response200Spec)
                .extract().as(ListOfBooksResponseModel.class);
    }

    public static void checkBooksListIsEmpty() {
        ListOfBooksResponseModel listOfBooksResponseModel = getListOfBooks();
        assertThat(listOfBooksResponseModel.getBooks()).isEmpty();
    }
}
