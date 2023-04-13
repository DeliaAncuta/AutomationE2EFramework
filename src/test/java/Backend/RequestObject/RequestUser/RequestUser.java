package Backend.RequestObject.RequestUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder

public class RequestUser {

    @JsonProperty("name")
    private String name;

    @JsonProperty("job")
    private String job;

    public static class RequestUserBuilder{
        public RequestUserBuilder() {
        }
    }
}
