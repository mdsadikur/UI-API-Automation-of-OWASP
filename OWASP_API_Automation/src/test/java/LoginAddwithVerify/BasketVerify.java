package LoginAddwithVerify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class BasketVerify extends BearerTokenAuthentication {

    @Test(priority = 1)
    public void addedIteminBusket() {

        JSONObject jsObject = new JSONObject();

        jsObject.put("productId", 1);
        jsObject.put("quantity", 1);

        given()
                .header("Authorization", "Bearer " + getBearerToken())
                .contentType("application/json")
                .body(jsObject)
                .log().uri()
                .log().body()
                .when()
                .post("/api/BasketItems/")
                .then()
                .statusCode(200)
                .log().body();

    }

    @Test(priority = 2)
    public void verifyItemIsInBasket() {

        given()
                .header("Authorization", "Bearer " + getBearerToken())
                .contentType("application/json")
                .log().uri()
                .log().body()
                .when()
                .get("/rest/basket")
                .then()
                .statusCode(200)
                .log().body();

    }



}
