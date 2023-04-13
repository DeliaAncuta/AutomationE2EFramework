package Tests;

import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ResourceRequestsTest extends Hooks {


    @Test(priority = 1)
    public void getResourceListTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_RESOURCE_LIST, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCES, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();
    }


    @Test(priority = 2)
    public void getResourceSingle(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_RESOURCE_LIST_SINGLE, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCE, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();
    }

    @Test(priority = 3)
    public void getResourceSingleNotFound(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_RESOURCE_NOT_FOUND, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCE, ResponseCodeType.STATUS_404);
        responseHelper.printResponseBody();
    }
}
