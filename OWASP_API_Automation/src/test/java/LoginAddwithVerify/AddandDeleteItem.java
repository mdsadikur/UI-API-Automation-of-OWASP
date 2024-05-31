package LoginAddwithVerify;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.testng.Assert.assertEquals;

public class AddandDeleteItem extends BearerTokenAuthentication {

    private String itemId1;
    private String itemId2;

    @Test(priority = 1)
    public void addedFirstItemToBasket() {
        JSONObject jsObject = new JSONObject();
        jsObject.put("productId", 1);
        jsObject.put("quantity", 1);

        Response response = given()
                .header("Authorization", "Bearer " + getBearerToken())
                .contentType("application/json")
                .body(jsObject)
                .log().uri()
                .log().body()
                .when()
                .post("/api/BasketItems/")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();

        itemId1 = response.jsonPath().getString("data.id");
    }

    @Test(priority = 2)
    public void addedSecondItemToBasket() {
        JSONObject jsObject = new JSONObject();
        jsObject.put("productId", 2);
        jsObject.put("quantity", 1);

        Response response = given()
                .header("Authorization", "Bearer " + getBearerToken())
                .contentType("application/json")
                .body(jsObject)
                .log().uri()
                .log().body()
                .when()
                .post("/api/BasketItems/")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();

        itemId2 = response.jsonPath().getString("data.id");
    }

    @Test(priority = 3)
    public void verifyItemsInBasket() {
        Response response = given()
                .header("Authorization", "Bearer " + getBearerToken())
                .contentType("application/json")
                .log().uri()
                .log().body()
                .when()
                .get("/rest/basket")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();

        int itemCount = response.jsonPath().getList("data").size();
        assertEquals(itemCount, 2, "Item count in basket is not correct");
    }

    @Test(priority = 4)
    public void deleteFirstItemFromBasket() {
        given()
                .header("Authorization", "Bearer " + getBearerToken())
                .log().uri()
                .when()
                .delete("/api/BasketItems/" + itemId1)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 5)
    public void verifyOnlyOneItemRemainsInBasket() {
        Response response = given()
                .header("Authorization", "Bearer " + getBearerToken())
                .contentType("application/json")
                .log().uri()
                .log().body()
                .when()
                .get("/rest/basket")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();

        int itemCount = response.jsonPath().getList("data").size();
        assertEquals(itemCount, 1, "Item count in basket is not correct");
    }
}