package TestsV2;

import Backend.RequestObject.RequestLogin.RequestPostUser;
import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import Frontend.Pages.LoginPage;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateUserTest extends Hooks {

    @Test(priority = 1)
    public void postLoginSuccessfulTest(){

        RequestPostUser loginSuccess = new RequestPostUser.RequestPostUserBuilder().userName("eve.holt@reqres.in").password("cityslicka").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+ RequestURLType.POST_USER, loginSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_LOGIN, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginValid(loginSuccess);

    }

}
