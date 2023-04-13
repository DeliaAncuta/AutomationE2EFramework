package Backend.ResponseObject.ResponseResources;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResourceData implements ResponseValidator {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("color")
    private String color;
    @JsonProperty("pantone_value")
    private String pantone_value;

    @Override
    public void validateResponse() {
        Assert.assertNotNull(id);
        Assert.assertNotNull(name);
        Assert.assertNotNull(year);
        Assert.assertNotNull(color);
        Assert.assertNotNull(pantone_value);
    }

    //conceptul de nested





}
