package Frontend.Pages;

import Backend.RequestObject.RequestLogin.RequestPostUser;
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }



    public void LoginValid(RequestPostUser requestPostUser){

        element.fillElement(userName , requestPostUser.getUserName());

        element.fillElement(parola, requestPostUser.getPassword());

        element.clickElement(Login);

    }
}
