package tests;

import api.BookStoreApi;
import extensions.WithLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;

public class ProfilePageTests extends BaseTest {

    @WithLogin
    @Test
    @DisplayName("Успешное удаление товара из корзины")
    void successfulDeleteBook() {
        BookStoreApi.deleteAllBooks();
        String bookId = "9781491904244";
        BookStoreApi.addBookToCart(bookId);

        ProfilePage.openPage();
        ProfilePage.deleteBook();

        ProfilePage.checkBookDeletedUI(bookId);
        BookStoreApi.checkBooksListIsEmpty();
    }
}
