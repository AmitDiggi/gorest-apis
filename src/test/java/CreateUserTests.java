import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    @Test
    public void shouldCreateMaleUser(){

        //Arrange
        String body = "{\n" +
                "    \"name\": \"guru\",\n" +
                "    \"email\": \"guru213@abc.com\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Action
        createUser(body)
                .then()
                .log().body()

        //Assert
        .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("guru213@abc.com"));
    }

    @Test
    public void shouldCreateFemaleUser(){

        //Arrange
        String body = "{\n" +
                "    \"name\": \"aditi\",\n" +
                "    \"email\": \"aditi.rao@abc.com\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
       //Act
        createUser(body)
                .then()
                .log().body()
        //Assert
        .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("aditi.rao@abc.com"));
    }

    private static Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer d33706d1eb07d903da18b04a08c1b9bfc438e4073c356477fe86c765fb023966")
                .body(body)

                .when()
                .post("https://gorest.co.in/public/v2/users");
    }
}
