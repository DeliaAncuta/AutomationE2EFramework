package Backend.ResponseObject;

import Backend.APIHelper;
import Backend.ResponseObject.ResponseBooks.ResponseBooksSuccess;
import Backend.ResponseObject.ResponseLogin.ResponseLoginFailed;
import Backend.ResponseObject.ResponseLogin.ResponseLoginSuccess;
import Backend.ResponseObject.ResponseToken.ResponseTokenSuccess;
import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseHelper {

    private Response response;
    private final APIHelper apiHelper = new APIHelper();

    public ResponseHelper(Response response) {
        this.response = response;
    }

    private void validateResponseCode(Integer expected){
        Assert.assertEquals(response.getStatusCode(), (int) expected);
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
        apiHelper.printResponseInfo(response);
    }


    public void validateResponse(String ResponseType, Integer ResponseCode) {
        validateResponseCode(ResponseCode);
        //user
        if (ResponseType.equals(ResponseBodyType.RESPONSE_USER)) {
            switch (ResponseCode) {
                case 201:
                    ResponseLoginSuccess ResponseLoginSuccess = response.getBody().as(ResponseLoginSuccess.class);
                    ResponseLoginSuccess.validateResponse();
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
        apiHelper.printResponseInfo(response);
    }

    //metoda generica
    public <T> T getSpecificObject(Class<T> Klass){
        return response.getBody().as(Klass);
    }

}
