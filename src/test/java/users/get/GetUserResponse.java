package users.get;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.create.CreateUserRequestBody;

@Getter
public class GetUserResponse {

    @Setter
    private int statusCode;

    private Data data;
    private String meta;

    public void assertUser(CreateUserRequestBody requestBody){

        Assert.assertEquals(data.email,requestBody.getEmail());
        Assert.assertEquals(data.name,requestBody.getName());
        Assert.assertEquals(data.gender,requestBody.getGender());
        Assert.assertEquals(data.status,requestBody.getStatus());

    }


    @Getter
    public static class Data{

        private String id;
        private String gender;
        private String name;
        private String email;
        private String status;
    }

}
