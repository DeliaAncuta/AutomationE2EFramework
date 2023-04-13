package Backend.ResponseObject;

import Backend.ResponseObject.ResponseLogin.ResponseLoginFailed;
import Backend.ResponseObject.ResponseLogin.ResponseLoginSuccess;
import Backend.ResponseObject.ResponseRegister.ResponseRegisterFailed;
import Backend.ResponseObject.ResponseRegister.ResponseRegisterSuccess;
import Backend.ResponseObject.ResponseResource.ResponseResourceSuccess;
import Backend.ResponseObject.ResponseResources.ResponseResourcesSuccess;
import Backend.ResponseObject.ResponseUser.RespinsePutPatchUser;
import Backend.ResponseObject.ResponseUser.ResponsePostUser;
import Backend.ResponseObject.ResponseUsers.ResponseUsersSuccess;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

public class ResponseHelper {

    private Response response;

    public ResponseHelper(Response response) {
        this.response = response;
    }

    public void validateResponseCode(Integer expected){
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), (int) expected); //am facut asta ca aternativa la sugestie intelig
    }

    public void validateResponse(String ResponseType, Integer ResponseCode, String Expected){
        validateResponseCode(ResponseCode);
        if (ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN)) {
            switch (ResponseCode) {
                case 400:
                    ResponseLoginFailed ResponseFailed = response.getBody().as(ResponseLoginFailed.class);
                    ResponseFailed.validateResponse(Expected);
                    break;
            }

        }
        if (ResponseType.equals(ResponseBodyType.RESPONSE_REGISTER)) {
            switch (ResponseCode) {
                case 400:
                    ResponseRegisterFailed ResponseRegisterFailed = response.getBody().as(Backend.ResponseObject.ResponseRegister.ResponseRegisterFailed.class);
                    ResponseRegisterFailed.validateResponse(Expected);
                    break;
            }
        }
    }
    //System.out.println(response.getStatusCode());
        //Assert.assertEquals(response.getStatusCode(), (int) ResponseCode);


    public void validateResponse(String ResponseType, Integer ResponseCode) {
        validateResponseCode(ResponseCode);
        //login
        if (ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN)) {
            switch (ResponseCode) {
                case 200:
                    ResponseLoginSuccess ResponseSuccess = response.getBody().as(ResponseLoginSuccess.class);
                    ResponseSuccess.validateResponse();
                    break;
            }

        }
        //Register
        if (ResponseType.equals(ResponseBodyType.RESPONSE_REGISTER)) {
            switch (ResponseCode) {
                case 200:
                    ResponseRegisterSuccess ResponseRegisterSuccess = response.getBody().as(Backend.ResponseObject.ResponseRegister.ResponseRegisterSuccess.class);
                    ResponseRegisterSuccess.validateResponse();
                    break;
            }
        }

        //Resources and Resource

        if(ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCES)){
            switch (ResponseCode) {
                case 200:
                    ResponseResourcesSuccess ResponseResourceSuccess = response.getBody().as(ResponseResourcesSuccess.class);
                    ResponseResourceSuccess.validateResponse();
                    break;
            }
        }

        if(ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCE)){
            switch (ResponseCode) {
                case 200:
                    ResponseResourceSuccess ResponseResourcesSuccess = response.getBody().as(ResponseResourceSuccess.class);
                    ResponseResourcesSuccess.validateResponse();
                    break;
                case 400:
                    Assert.assertNotNull(response);
                    break;
            }
        }

        if(ResponseType.equals(ResponseBodyType.RESPONSE_USER)){
            switch (ResponseCode) {
                case 201:
                    ResponsePostUser ResponseUser = response.getBody().as(ResponsePostUser.class);
                    ResponseUser.validateResponse();
                    break;
                case 200:
                    RespinsePutPatchUser ResponsePutPatchUser = response.getBody().as(RespinsePutPatchUser.class);
                    ResponsePutPatchUser.validateResponse();
                    break;
                case 204:
                    Assert.assertNotNull(response.getBody());
                    break;
            }
        }

        if(ResponseType.equals(ResponseBodyType.RESPONSE_USERS)){
            switch (ResponseCode) {
                case 200:
                    ResponseUsersSuccess ResponseUsers = response.getBody().as(ResponseUsersSuccess.class);
                    ResponseUsers.validateResponse();
                    break;
                case 404:
                    Assert.assertNotNull(response.getBody());
                    break;
            }
        }


    }
        public void printResponseBody () {
            ResponseBody body = response.getBody();
            System.out.println(body.asString());
        }
}
