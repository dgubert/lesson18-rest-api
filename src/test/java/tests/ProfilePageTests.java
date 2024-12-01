package tests;

import api.AccountApi;
import api.BookStoreApi;
import extensions.WithLogin;
import models.ListOfBooksResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfilePageTests extends BaseTest {

    @WithLogin
    @Test
    @DisplayName("Успешное удаление товара из корзины")
    void successfulDeleteBook() {
        String bookId = "9781491904244";

        BookStoreApi.deleteAllBooks();
        BookStoreApi.addBookToCart(bookId);

        ProfilePage.openPage();
        ProfilePage.deleteBook();
        ProfilePage.checkBookDeletedUI(bookId);

        BookStoreApi.checkBooksListIsEmpty();
    }
}
