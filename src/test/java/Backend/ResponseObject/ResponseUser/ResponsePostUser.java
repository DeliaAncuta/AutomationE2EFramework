package Backend.ResponseObject.ResponseUser;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponsePostUser implements ResponseValidator {

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;

    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private String createdAt;


    @Override
    public void validateResponse() {
        Assert.assertNotNull(name);
        Assert.assertNotNull(job);
        Assert.assertNotNull(id);
        Assert.assertNotNull(createdAt);
    }
}
