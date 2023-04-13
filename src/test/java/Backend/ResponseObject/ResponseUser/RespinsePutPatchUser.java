package Backend.ResponseObject.ResponseUser;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class RespinsePutPatchUser implements ResponseValidator {

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("updatedAt")
    private String updatedAt;

    @Override
    public void validateResponse() {
        Assert.assertNotNull(name);
        Assert.assertNotNull(job);
        Assert.assertNotNull(updatedAt);
    }
}
