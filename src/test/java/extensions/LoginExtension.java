package extensions;

import api.AccountApi;
import io.qameta.allure.Step;
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
    @Step("Авторизируемся пользователем через API")
    public void beforeEach(ExtensionContext context) {
        response = AccountApi.getAuthorizationResponse();

        open("/images/Toolsqa.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", response.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("expires", response.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("token", response.getToken()));
    }

}