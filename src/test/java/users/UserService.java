package users;

import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import users.get.GetUserErrorResponse;
import users.get.GetUserResponse;
import users.getall.GetAllUsersResponse;

public class UserService {

    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = new UsersClient().create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.getStatusCode());

        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){

        Response response = new UsersClient().create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.getStatusCode());
        return errorResponse;
    }

    public GetAllUsersResponse getAllUsers() {
        Response response = new UsersClient().getAll();
        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatusCode(response.getStatusCode());
        return getAllUsersResponse;
    }

    public GetUserResponse getUser(int id){

        Response response = new UsersClient().get(id);
        GetUserResponse getUserResponse = response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(response.getStatusCode());

        return  getUserResponse;
    }

    public GetUserErrorResponse getUserExpectingError(int id){
        Response response = new UsersClient().get(id);
        GetUserErrorResponse getUserResponse = response.as(GetUserErrorResponse.class);
        getUserResponse.setStatusCode(response.getStatusCode());

        return  getUserResponse;
    }

    public GetUserResponse updateUserName(GetUserResponse userResponse, String name){
        Response response = new UsersClient().update(userResponse, name);
        GetUserResponse getUserResponse = response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(response.getStatusCode());

        return getUserResponse;
    }

    public int deleteUser(int id){

        Response response = new UsersClient().delete(id);
        return  response.getStatusCode();
    }


}
