package Backend.ResponseObject.ResponseLogin;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.testng.Assert;

import java.util.List;

@Getter
public class ResponseUserSuccess implements ResponseValidator {

    @JsonProperty("userID")
    private String userID;

    @JsonProperty("username")
    private String username;

    @JsonProperty("books")
    private List<BookObject> books;


    public void validateResponse() {

        Assert.assertNotNull(userID);
        Assert.assertNotNull(username);
        Assert.assertNotNull(books);
    }

}
