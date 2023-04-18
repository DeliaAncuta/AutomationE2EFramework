package Backend.RequestObject.RequestTokenUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


@Builder

public class RequestTokenUser {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    public static class RequestTokenUserBuilder{
        public RequestTokenUserBuilder() {
        }
    }
}
