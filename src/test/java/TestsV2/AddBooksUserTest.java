package TestsV2;

import Backend.RequestObject.RequestBooks.ISBNObject;
import Backend.RequestObject.RequestBooks.RequestPostBooks;
import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestTokenUser.RequestTokenUser;
import Backend.RequestObject.RequestURLType;
import Backend.RequestObject.RequestUser.RequestPostUser;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import Backend.ResponseObject.ResponseLogin.ResponseUserSuccess;
import Backend.ResponseObject.ResponseToken.ResponseTokenSuccess;
import Frontend.Pages.LoginPage;
import Frontend.Pages.ProfilePage;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddBooksUserTest extends Hooks {

    public static String userID;
    public static String Token;



    @Test
    public void addBooks(){

        String username = "probaItSchool" + System.currentTimeMillis();
        String password = "Cityslicka123@#!";
        List<ISBNObject> expectedListIsbns = Arrays.asList(new ISBNObject("9781449325862"),new ISBNObject("9781449331818"));
        System.out.println("Step 1");
        var RequestObject = GetPostUser(username, password);
        System.out.println("Step 2");
        PostTokenUser(username, password);
        System.out.println("Step 3");
        PostBooksUser(expectedListIsbns);

        //punem un threadsleep pt ca problema de replicare intre 2 componente web

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginValid(RequestObject);

        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.validateLogin(RequestObject);
        profilePage.validateProfileBooks(getListStringISBN(expectedListIsbns));
    }

    public List<String> getListStringISBN(List<ISBNObject> expectedListIsbns){
        List<String> expected = new ArrayList<>();
        for(Integer i = 0; i<expectedListIsbns.size(); i++){
            expected.add(expectedListIsbns.get(i).getIsbn());
        }
        return expected;
    }

    public RequestPostUser GetPostUser(String username, String password){

        RequestPostUser loginSuccess = new RequestPostUser.RequestPostUserBuilder().userName(username).password(password).build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, RequestURLType.POST_USER, loginSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_201);
        responseHelper.printResponseBody();
        var responseObject = responseHelper.getSpecificObject(ResponseUserSuccess.class);
        userID = responseObject.getUserID();
        return loginSuccess;
    }

    public void PostTokenUser(String username, String password){

        RequestTokenUser tokenSuccess = new RequestTokenUser.RequestTokenUserBuilder().userName(username).password(password).build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, RequestURLType.POST_TOKEN, tokenSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_TOKEN, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

        var responseObject = responseHelper.getSpecificObject(ResponseTokenSuccess.class);
        Token = responseObject.getToken();
    }

    public void PostBooksUser(List<ISBNObject> ISBNs){

        RequestPostBooks booksSuccess = new RequestPostBooks.RequestPostBooksBuilder().userId(userID).collectionOfIsbns(ISBNs).build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, RequestURLType.POST_BOOKS, booksSuccess, Token);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_BOOKS, ResponseCodeType.STATUS_201);
        responseHelper.printResponseBody();
    }





}
