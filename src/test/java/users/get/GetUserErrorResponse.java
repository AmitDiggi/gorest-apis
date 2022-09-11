package users.get;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.create.CreateUserRequestBody;

@Getter
public class GetUserErrorResponse {

    @Setter
    private int statusCode;

    private Data data;
    private String meta;

    public void assertUser(int expectedStatusCode, String expectedErrorMessage){

        Assert.assertEquals(statusCode,expectedStatusCode);
        Assert.assertEquals(data.message,expectedErrorMessage);

    }

    
    @Getter
    public static class Data{

        private String id;
        private String message;
    }

}
