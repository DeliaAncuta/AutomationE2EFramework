package Tests;

import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class UsersRequestsTests extends Hooks {

    @Test
    public void getListUsersTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+ RequestURLType.GET_LIST_USERS, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();
    }

    @Test
    public void getSingleUserTest(){ //tema

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+ RequestURLType.GET_SINGLE_USERS, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();
    }

    @Test
    public void getUserNotFound(){
        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+RequestURLType.GET_SINGLE_USERS_NOTFOUND, null);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_404);
        responseHelper.printResponseBody();
    }

    @Test
    public void getDelayedRequestTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+RequestURLType.GET_DELAYED_RESPONSE, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }

}
