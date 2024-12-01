package extensions;

import api.AccountApi;
import models.LoginResponseModel;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class LoginExtension implements BeforeEachCallback {

    public static LoginResponseModel response;

    @Override
    public void beforeEach(ExtensionContext context) {
        step("Авторизируемся через API", () -> {
            response = AccountApi.getAuthorizationResponse();

            open("/images/Toolsqa.jpg");
            getWebDriver().manage().addCookie(new Cookie("userID", response.getUserId()));
            getWebDriver().manage().addCookie(new Cookie("expires", response.getExpires()));
            getWebDriver().manage().addCookie(new Cookie("token", response.getToken()));
        });

    }

}