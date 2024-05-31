package LoginAddwithVerify;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BearerTokenAuthentication {


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://juice-shop.herokuapp.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public String getBearerToken() {

        Map map = new HashMap();
        map.put("email", "mdsadikurrahman26@gmail.com");
        map.put("password", "sadik3322");

        return given()
                .contentType("application/json")
                .accept("application/json, text/plain, */*")
                .body(map)
                .log().uri()
                .log().body()
                .when()
                .post("/rest/user/login")
                .then()
                .statusCode(200)
                .log().body()
                .extract().jsonPath().getString("authentication.token");
    }

    public RequestSpecification requestSpecification() {
        return given()
                .header("Authorization", "Bearer " + getBearerToken())
                .contentType("application/json");
    }
}
