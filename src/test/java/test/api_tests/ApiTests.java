package test.api_tests;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {

    @BeforeClass
    public static void setup() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void checkExistingUser() {
        // all number of users is 12
        when().get("/users/2").then().statusCode(200)
                .assertThat().body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"));
    }

    @Test
    public void checkNonExistingUser() {
        when().get("/user/13").then().statusCode(404);
    }

    @Test
    public void deleteUser() {
        when().delete("/user/2")
                .then().statusCode(204);
    }
}
