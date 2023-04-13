package Backend.ResponseObject.ResponseLogin;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;


public class ResponseLoginSuccess implements ResponseValidator {

    @JsonProperty("token")
    private String Token;


    public void validateResponse() {
        Assert.assertNotNull(Token);
    }

}
