package ShareData;

import Backend.RequestObject.RequestHelper;
import Backend.ResponseObject.ResponseHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends ShareData{


    public RequestHelper requestHelper;
    public ResponseHelper responseHelper;



    @BeforeMethod
    public void prepareEnviroment(){

        setupChrome();
        requestHelper = new RequestHelper();


    }

    @AfterMethod
    public void clearEnviroment(){

        //clearBrowser();
    }

}
