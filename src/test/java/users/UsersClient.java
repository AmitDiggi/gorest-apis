package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import users.get.GetUserResponse;
import users.getall.GetAllUsersResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {


    public Response create(CreateUserRequestBody body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer d33706d1eb07d903da18b04a08c1b9bfc438e4073c356477fe86c765fb023966")
                .body(body)

                .when()
                .post("https://gorest.co.in/public/v1/users");
        response
                .then()
                    .log()
                        .body();
        return response;
    }





    public Response getAll() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response.then().log().body();
        return response;
    }



    public Response get(int id) {
        Response response = given()
                .header("Authorization", "Bearer d33706d1eb07d903da18b04a08c1b9bfc438e4073c356477fe86c765fb023966")
                .pathParams("id", id)
                .when()
                .get("https://gorest.co.in/public/v1/users/{id}");
        response.then().log().body();
        return response;
    }

    public Response update(GetUserResponse userResponse, String name) {
        String requestBody = "{\"name\":\""+name+"\"}";
        Response response = given()
                .header("Authorization", "Bearer d33706d1eb07d903da18b04a08c1b9bfc438e4073c356477fe86c765fb023966")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParams("id", userResponse.getData().getId())
                .when()
                .patch("https://gorest.co.in/public/v1/users/{id}");
        System.out.println("Hello-------------\n"+response.asString());

       // response.then().log().body();
        return response;
    }

    public Response delete(int id) {
        Response response = given()
                .header("Authorization", "Bearer d33706d1eb07d903da18b04a08c1b9bfc438e4073c356477fe86c765fb023966")
                .pathParams("id", id)
                .when()
                .delete("https://gorest.co.in/public/v1/users/{id}");
        response.then().log().body();
        return response;
    }
}
