package Tests;

import ShareData.Hooks;

public class LoginRequestsTests extends Hooks {

    /*@Test(priority = 1)
    public void postLoginSuccessfulTest(){

        RequestPostUser loginSuccess = new RequestPostUser.RequestLoginBuilder().Email("eve.holt@reqres.in").Password("cityslicka").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+ RequestURLType.POST_LOGIN, loginSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_LOGIN, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

        //serializare pe request si deserializare pe response
    }

    @Test(priority = 2)
    public void postLoginUnSuccessfulTest(){
        //Header

        RequestPostUser requestPostUserUnsuccessful = new RequestPostUser.RequestLoginBuilder().Email("eve.holt@reqres.in").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+ RequestURLType.POST_LOGIN, requestPostUserUnsuccessful);

        String ExpectedError = "Missing password";
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_LOGIN, ResponseCodeType.STATUS_400, ExpectedError);
        responseHelper.printResponseBody();

    }*/
}
