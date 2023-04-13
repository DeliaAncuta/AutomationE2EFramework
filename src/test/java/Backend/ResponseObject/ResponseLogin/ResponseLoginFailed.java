package Backend.ResponseObject.ResponseLogin;

import Backend.ResponseObject.ResponseSpecificValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseLoginFailed implements ResponseSpecificValidator {
    @JsonProperty("error")
    public String Error;

    @Override
    public void validateResponse(String Expected) {
        Assert.assertNotNull(Error, Expected);
    }
}
