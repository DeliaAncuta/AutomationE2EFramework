package Tests;

import ShareData.Hooks;

public class RegisterRequestsTests extends Hooks {

    /*@Test(priority = 1)
    public void postRegisterSuccessfulTest(){

        RequestRegister requestRegister = new RequestRegister.RequestRegisterBuilder().Email("eve.holt@reqres.in").Password("pistol").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+RequestURLType.POST_REGISTER, requestRegister);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_REGISTER, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }

    @Test(priority = 2)
    public void postRegisterUnSuccesfulTest(){

        RequestRegister requestRegister = new RequestRegister.RequestRegisterBuilder().Email("sydney@fife").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+RequestURLType.POST_REGISTER, requestRegister);

        String ExpectedError = "Missing password";

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_REGISTER, ResponseCodeType.STATUS_400, ExpectedError);
        responseHelper.printResponseBody();
    }*/
}
