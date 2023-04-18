package Backend.RequestObject.RequestBooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder

public class RequestPostBooks {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("collectionOfIsbns")
    private List<ISBNObject> collectionOfIsbns;

    public static class RequestPostBooksBuilder{
        public RequestPostBooksBuilder() {
        }
    }
}
