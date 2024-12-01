package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {

    //SelenideElement
    public static void openPage() {
        open("/profile");
    }

    public static void deleteBook() {
        $("#delete-record-undefined").click();
        $("#closeSmallModal-ok").click();
    }

    public static void checkBookDeletedUI(String bookId) {
        $("[href=profile?book=" + bookId + "]").shouldBe(visible);
    }
}
