package ShareData;

import Backend.RequestObject.RequestHelper;
import Backend.ResponseObject.ResponseHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends ShareData{


    public RequestHelper requestHelper;
    public ResponseHelper responseHelper;
    public String baseURL = "https://bookstore.toolsqa.com";



    @BeforeMethod
    public void prepareEnviroment(){

        setupChrome();
        requestHelper = new RequestHelper();


    }

    @AfterMethod
    public void clearEnviroment(){ //listener din testng

        //clearBrowser();
    }

}
