package Backend.RequestObject.RequestUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
@Builder
@Getter

public class RequestPostUser {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    public static class RequestPostUserBuilder{
        public RequestPostUserBuilder() {
        }
    }

}
