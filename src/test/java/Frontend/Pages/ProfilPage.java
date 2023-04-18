package Frontend.Pages;

import Backend.RequestObject.RequestUser.RequestPostUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilPage extends BasePage {

    public ProfilPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName-value")
    private WebElement userName;

    @FindBy(xpath = "//button[text()='Log out']")
    private WebElement logOut;

    public void validateLogin(RequestPostUser postUser){
        element.validateElementText(userName, postUser.getUserName());
    }

    public void logOut(){
        element.clickElement(logOut);
    }
}
