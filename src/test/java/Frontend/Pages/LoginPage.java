package Frontend.Pages;

import Backend.RequestObject.RequestUser.RequestPostUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {



    @FindBy(id="userName")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement parola;

    @FindBy(id="login")
    private WebElement Login;

    @FindBy(xpath="//h5")
    private WebElement LoginMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }



    public void LoginValid(RequestPostUser requestPostUser){
        element.forceWait(3000);

        element.scrollByPixel(0, 400);

        element.fillElement(userName , requestPostUser.getUserName());

        element.fillElement(parola, requestPostUser.getPassword());


        element.clickElement(Login);
    }

    public void validateLoginMessage(){
        element.validateElementText(LoginMessage,"Login in Book Store");
    }
}
