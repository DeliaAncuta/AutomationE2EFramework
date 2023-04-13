package Backend.ResponseObject.ResponseUsers;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

import java.util.List;

public class ResponseUsersSuccess implements ResponseValidator {

    @JsonProperty("page")
    public Integer Page;
    @JsonProperty("per_page")
    public Integer Per_page;
    @JsonProperty("total")
    public Integer Total;
    @JsonProperty("total_pages")
    public Integer Total_pages;

    @JsonProperty("data")
    private List<UsersData> data;

    @JsonProperty("support")
    private UsersSupport support;

    @Override
    public void validateResponse() {
        Assert.assertNotNull(Page);
        Assert.assertNotNull(Per_page);
        Assert.assertNotNull(Total);
        Assert.assertNotNull(Total_pages);
        Assert.assertNotNull(data);

        for(Integer i=0; i<data.size(); i++){
           data.get(i).validateResponse();
        }

        Assert.assertNotNull(support);
        support.validateResponse();
    }
}
