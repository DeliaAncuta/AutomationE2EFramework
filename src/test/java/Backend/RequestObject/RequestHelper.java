package Backend.RequestObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class RequestHelper {

    private Response response;

    private RequestSpecification request;

    public RequestHelper() {
        request = RestAssured.given();
        request.header("Content-Type", "application/json" );
    }

    public Response performRequest(String requestType, String endPoint, Object body){
       switch (requestType){
           case "get" : response = request.get(endPoint);
            break;
           case "post" :
               request.body(body);
               response = request.post(endPoint);
               break;
           case "put" :
               request.body(body);
               response = request.put(endPoint);
               break;
           case "patch" :
               request.body(body);
               response = request.patch(endPoint);
               break;
           case "delete" :
               response = request.delete(endPoint);
               break;
       }
        Assert.assertNotNull(response, "Request is not perform!!");
    return response;
    }


}
