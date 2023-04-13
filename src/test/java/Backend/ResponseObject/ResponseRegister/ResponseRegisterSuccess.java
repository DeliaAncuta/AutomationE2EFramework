package Backend.ResponseObject.ResponseRegister;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseRegisterSuccess implements ResponseValidator {

    @JsonProperty("token")
    private String Token;

    @JsonProperty("id")
    private Integer Id;

    public void validateResponse() {
        Assert.assertNotNull(Token);
        Assert.assertNotNull(Id);
    }
}
