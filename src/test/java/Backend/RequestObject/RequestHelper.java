package Backend.RequestObject;

import Backend.APIHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class RequestHelper {

    private Response response;

    private RequestSpecification request;

    private final APIHelper apiHelper = new APIHelper();

    public RequestHelper() {
        request = RestAssured.given();
        request.header("Content-Type", "application/json" );
    }

    public Response performRequest(String requestType, String endPoint, Object body) {

        String baseURL = "https://bookstore.toolsqa.com";
        request.baseUri(baseURL);
        request.basePath(endPoint);

        switch (requestType) {
            case "get":
                response = request.get();
                break;
            case "post":
                request.body(body);
                response = request.post();
                break;
            case "put":
                request.body(body);
                response = request.put();
                break;
            case "patch":
                request.body(body);
                response = request.patch();
                break;
            case "delete":
                response = request.delete();
                break;
        }
        Assert.assertNotNull(response, "Request is not perform!!");
        apiHelper.printRequestInfo(request);
        return response;
    }

    public Response performRequest(String requestType, String endPoint, Object body, String Token) {

        String baseURL = "https://bookstore.toolsqa.com";
        request.baseUri(baseURL);
        request.basePath(endPoint);
        request.headers("Authorization", "Bearer " + Token);
        switch (requestType) {
            case "post":
                request.body(body);
                response = request.post();
                break;
        }
        Assert.assertNotNull(response, "Request is not perform!!");
        apiHelper.printRequestInfo(request);
        return response;
    }


}
