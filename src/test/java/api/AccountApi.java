package api;

import models.AuthorizationModel;
import models.ListOfBooksResponseModel;
import models.LoginResponseModel;

import static extensions.LoginExtension.response;
import static io.restassured.RestAssured.given;
import static specs.RequestSpec.requestSpec;
import static specs.ResponseSpec.response200Spec;

public class AccountApi {
    public static String username = "dg",
            password = "Password1!";

    public static LoginResponseModel getAuthorizationResponse() {
        AuthorizationModel authorizationModel = new AuthorizationModel();
        authorizationModel.setUserName(username);
        authorizationModel.setPassword(password);

        return given(requestSpec)
                .body(authorizationModel)
            .when()
                .post("/Account/v1/Login")
            .then()
                .spec(response200Spec)
                .extract().response().as(LoginResponseModel.class);
    }
}
