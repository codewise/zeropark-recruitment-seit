package pl.zeropark.recruitment.sdit.httpbin.rest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import pl.zeropark.recruitment.sdit.httpbin.Constants;

public class HttpBinRestTest {

    @Test
    void shouldGetMessage() {
        httpBinRequest()
                .when()
                .get("/status/200")
                .then()
                .statusCode(200);
    }


    private RequestSpecification httpBinRequest() {
        return RestAssured.given()
                .baseUri(Constants.HTTPBIN_URL)
                .log().all().then().log().all()
                .request();
    }
}
