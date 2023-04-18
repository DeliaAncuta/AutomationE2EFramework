package Backend.ResponseObject.ResponseToken;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.testng.Assert;


@Getter
public class ResponseTokenSuccess implements ResponseValidator {

    @JsonProperty("token")
    private String Token;

    @JsonProperty("expires")
    private String expires;

    @JsonProperty("status")
    private String status;

    @JsonProperty("result")
    private String result;

    public void validateResponse() {
        Assert.assertNotNull(Token);
        Assert.assertNotNull(expires);
        Assert.assertNotNull(status);
        Assert.assertNotNull(result);
    }
}
