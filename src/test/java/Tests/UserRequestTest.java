package Tests;

import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.RequestObject.RequestBooks.RequestPostBooks;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserRequestTest extends Hooks {

    /*@Test(priority = 1)
    public void postUserTest(){

        RequestPostBooks requestPostBooks = new RequestPostBooks.RequestUserBuilder().name("morpheus").job("leader").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+ RequestURLType.POST_USER, requestPostBooks);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_201);
        responseHelper.printResponseBody();
    }

    @Test(priority = 2)
    public void putUserTest(){

        RequestPostBooks requestPostBooks = new RequestPostBooks.RequestUserBuilder().name("morpheus").job("leader").build();
        Response response = requestHelper.performRequest(RequestMethodType.PUT_METHOD, baseURL+ RequestURLType.PUT_PATCH_DELETE_USER, requestPostBooks);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }

    @Test(priority = 3)
    public void patchUserTest(){

        RequestPostBooks requestPostBooks = new RequestPostBooks.RequestUserBuilder().name("morpheus").job("zion resident").build();
        Response response = requestHelper.performRequest(RequestMethodType.PATCH_METHOD, baseURL+ RequestURLType.PUT_PATCH_DELETE_USER, requestPostBooks);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();


    }

    @Test(priority = 4)
    public void deleteUserTest(){

        Response response = requestHelper.performRequest(RequestMethodType.DELETE_METHOD, baseURL+ RequestURLType.PUT_PATCH_DELETE_USER, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_204);
        responseHelper.printResponseBody();

    }*/



}
