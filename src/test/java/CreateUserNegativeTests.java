import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

import java.util.UUID;


public class CreateUserNegativeTests {

    private UserService userService;
    @BeforeClass
    public void beforeClass(){
        userService = new UserService();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //1. Arrange
       // CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("aditi").gender("female").email("aaa.com").status("active").build();

        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().email("abc").build();

        //Act
       CreateUserErrorResponse errorResponse = userService.createUserExpectingError(createUserRequestBody);

       //Assert
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("email", "is invalid");

    }

    @Test
    public void shouldNotAllowToCreateUserWithBlankGenderAndStatus(){
        //1. Arrange

        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().name("aditi").gender("").status("").build();

        //Act
        CreateUserErrorResponse errorResponse = userService.createUserExpectingError(createUserRequestBody);

        //Assert
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("gender", "can't be blank, can be male of female");
        errorResponse.assertHasError("status", "can't be blank");


    }
}
