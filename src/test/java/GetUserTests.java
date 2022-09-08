import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserTests {

    @Test
    public void shouldGetAllUsers(){

        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .log().body()
                .body("data", Matchers.hasSize(10))
                .body("data", Matchers.hasItem(Matchers.hasEntry("gender", "male")));

       // Assert.assertEquals(1,1);
    }


}
