package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {

    final static SelenideElement deleteBookBtn = $("#delete-record-undefined"),
        confirmDeleteRecordBtn = $("#closeSmallModal-ok");


    @Step("Открываем страницу профиля пользователя")
    public static void openPage() {
        open("/profile");
    }

    @Step("Удаляем из корзины книгу {0}")
    public static void deleteBook(String book) {
        deleteBookBtn.click();
        confirmDeleteRecordBtn.click();
    }

    @Step("Проверяем через UI отсутствие книги {0} в корзине")
    public static void checkBookDeletedUI(String bookId) {
        $("[href=profile?book=" + bookId + "]").shouldBe(visible);
    }
}
