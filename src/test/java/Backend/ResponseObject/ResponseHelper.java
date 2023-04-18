package Backend.ResponseObject;

import Backend.ResponseObject.ResponseBooks.ResponseBooksSuccess;
import Backend.ResponseObject.ResponseLogin.ResponseLoginFailed;
import Backend.ResponseObject.ResponseLogin.ResponseUserSuccess;
import Backend.ResponseObject.ResponseToken.ResponseTokenSuccess;
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
        /*if (ResponseType.equals(ResponseBodyType.RESPONSE_REGISTER)) {
            switch (ResponseCode) {
                case 400:
                    ResponseRegisterFailed ResponseRegisterFailed = response.getBody().as(Backend.ResponseObject.ResponseToken.ResponseRegisterFailed.class);
                    ResponseRegisterFailed.validateResponse(Expected);
                    break;
            }
        }*/
    }
    //System.out.println(response.getStatusCode());
        //Assert.assertEquals(response.getStatusCode(), (int) ResponseCode);


    public void validateResponse(String ResponseType, Integer ResponseCode) {
        validateResponseCode(ResponseCode);
        //user
        if (ResponseType.equals(ResponseBodyType.RESPONSE_USER)) {
            switch (ResponseCode) {
                case 201:
                    ResponseUserSuccess ResponseUserSuccess = response.getBody().as(Backend.ResponseObject.ResponseLogin.ResponseUserSuccess.class);
                    ResponseUserSuccess.validateResponse();
                    break;
            }

        }

        if (ResponseType.equals(ResponseBodyType.RESPONSE_TOKEN)) {
            switch (ResponseCode) {
                case 200:
                    ResponseTokenSuccess ResponseTokenSuccess = response.getBody().as(ResponseTokenSuccess.class);
                    ResponseTokenSuccess.validateResponse();
                    break;

            }
        }

        if (ResponseType.equals(ResponseBodyType.RESPONSE_BOOKS)) {
            switch (ResponseCode) {
                case 201:
                    ResponseBooksSuccess ResponseBooksSuccess = response.getBody().as(ResponseBooksSuccess.class);
                    ResponseBooksSuccess.validateResponse();
                    break;
            }
        }

    }

    //metoda generica
    public <T> T getSpecificObject(Class<T> Klass){
        return response.getBody().as(Klass);
    }

    public void printResponseBody() {
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
    }
}
