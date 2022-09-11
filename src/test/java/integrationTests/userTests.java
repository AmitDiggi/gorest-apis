package integrationTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;
import users.create.CreateUserRequestBody;
import users.get.GetUserResponse;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class userTests {
    private UserService userService;

    @BeforeClass
    public void beforeClass() {
        userService = new UserService();
    }

    @Test
    public void shouldCreateAndGetUser() {


        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();

        //Action

        int id = userService.createUser(createUserRequestBody).getData().getId();

        //Assert
        userService.getUser(id).assertUser(createUserRequestBody);


    }

    @Test
    public void shouldCreateAndDeleteUser(){

        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();

        //Action
        int id = userService.createUser(createUserRequestBody).getData().getId();
        userService.getUser(id).assertUser(createUserRequestBody);
        int statusCode = userService.deleteUser(id);

        //Assert
        Assert.assertEquals(statusCode,204);
        userService.getUserExpectingError(id).assertUser(404, "Resource not found");

    }

    @Test
    public void shouldCreateAndUpdateUser(){
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();
       String name = String.format("vinay%s", UUID.randomUUID());

        //Action
        int id = userService.createUser(createUserRequestBody).getData().getId();
        GetUserResponse userResponse = userService.getUser(id); //.assertUser(createUserRequestBody);
       userResponse = userService.updateUserName(userResponse, name);

        //Assert
        Assert.assertEquals(userResponse.getData().getName(), name);


    }

}
