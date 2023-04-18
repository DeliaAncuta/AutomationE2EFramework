package Backend.RequestObject.RequestBooks;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ISBNObject {

    public ISBNObject(String isbn) {
        this.isbn = isbn;
    }

    @JsonProperty("isbn")
    private String isbn;

}
