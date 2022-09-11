import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;
import users.UsersClient;
import users.getall.GetAllUsersResponse;

import static io.restassured.RestAssured.given;

public class GetUserTests {

    UserService userService;

    @BeforeClass
    public void beforeClassMethod(){
        userService = new UserService();
    }

    @Test
    public void shouldGetAllUsers(){

        GetAllUsersResponse getAllUsersResponse = userService.getAllUsers();

        //Assert
        Assert.assertEquals(getAllUsersResponse.getStatusCode(),200);
        Assert.assertEquals(getAllUsersResponse.getDataList().size(),10);
        Assert.assertTrue(getAllUsersResponse.hasMaleUser());

       // Assert.assertEquals(1,1);
    }




}
