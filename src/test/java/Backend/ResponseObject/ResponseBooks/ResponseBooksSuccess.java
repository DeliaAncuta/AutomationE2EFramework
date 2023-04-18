package Backend.ResponseObject.ResponseBooks;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

import java.util.List;

public class ResponseBooksSuccess implements ResponseValidator {

    @JsonProperty("books")
    private List <ISBNObject> books;

    @Override
    public void validateResponse() {
        Assert.assertNotNull(books);
    }

    //conceptul de nested





}
