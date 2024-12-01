package specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static tests.BaseTest.withCustomTemplates;

public class RequestSpec {
    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType("application/json")
            .baseUri("https://demoqa.com");
}