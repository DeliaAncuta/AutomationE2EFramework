package Backend.RequestObject.RequestRegister;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder

public class RequestRegister {

    @JsonProperty("email")
    private String Email;

    @JsonProperty("password")
    private String Password;

    public static class RequestRegisterBuilder{
        public RequestRegisterBuilder() {
        }
    }
}
