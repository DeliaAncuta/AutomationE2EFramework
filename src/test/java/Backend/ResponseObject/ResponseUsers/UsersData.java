package Backend.ResponseObject.ResponseUsers;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class UsersData implements ResponseValidator {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("first_name")
    private Integer first_name;
    @JsonProperty("last_name")
    private String last_name;
    @JsonProperty("avatar")
    private String avatar;

    @Override
    public void validateResponse() {
        Assert.assertNotNull(id);
        Assert.assertNotNull(email);
        Assert.assertNotNull(first_name);
        Assert.assertNotNull(last_name);
        Assert.assertNotNull(avatar);
    }

    //conceptul de nested





}
