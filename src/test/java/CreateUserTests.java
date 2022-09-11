import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;


public class CreateUserTests {

    private UserService userService;

    @BeforeClass
    public void beforeClass(){
        userService = new UserService();
    }

    @Test
    public void shouldCreateMaleUser(){


        //Arrange
        String email = UUID.randomUUID() + "@gmail.com";

        //  CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
     //   CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("guru").gender("male").email(email).status("active").build();

        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().gender("male").build();

        //Action
       // usersClient.createUser(requestBody);
        CreateUserResponse createUserResponse = userService.createUser(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);


    }

    @Test
    public void shouldCreateFemaleUser(){

        //Arrange
        String email = UUID.randomUUID() + "@gmail.com";
       // CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("aditi").gender("female").email(email).status("active").build();
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().gender("female").build();

        //Act
        CreateUserResponse createUserResponse = userService.createUser(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);
    }

}
