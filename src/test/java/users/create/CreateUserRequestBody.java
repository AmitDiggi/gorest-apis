package users.create;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {
    private String name;
    private String gender;
    private String email;
    private String status;


    public CreateUserRequestBody(Builder builder) {

        this.name = builder.name;
        this.gender = builder.gender;;
        this.email = builder.email;
        this.status = builder.status;
    }

    public static class Builder{

        private String name;
        private String gender;
        private String email;
        private String status;

        public Builder(){
            this.name = "Tenali";
            this.gender = "male";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());
            this.status = "active";

        }

        public Builder name(String name){

            this.name = name;
            return this;
        }
        public Builder gender(String gender){

            this.gender = gender;
            return this;
        }

        public Builder email(String email){

            this.email = email;
            return this;
        }
        public Builder status(String status){

            this.status = status;
            return this;
        }


        public CreateUserRequestBody build(){
            CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody(this);
            return createUserRequestBody;
        }
    }


}
