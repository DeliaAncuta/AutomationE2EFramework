package Frontend.Pages;

import Backend.RequestObject.RequestBooks.ISBNObject;
import Backend.RequestObject.RequestUser.RequestPostUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName-value")
    private WebElement userName;

    @FindBy(xpath = "//button[text()='Log out']")
    private WebElement logOut;

    @FindBy(css=".rt-tbody .mr-2>a")
    private List<WebElement> profileBooks;


    public void validateLogin(RequestPostUser postUser){
        element.validateElementText(userName, postUser.getUserName());
    }

    public void logOut(){
        element.clickElement(logOut);
    }

    public void validateProfileBooks(List<String> expectedListIsbns){

        int contor = 0;


        for(Integer i=0; i<profileBooks.size(); i++){
            element.clickElement(profileBooks.get(i));

            ProfileBookPage profileBookPage = new ProfileBookPage(driver);
            String expectedISBN = profileBookPage.getISBNValue();
            profileBookPage.clickBackBtn();
            if(expectedListIsbns.contains(expectedISBN)){
                contor++;
                System.out.println("test");
            }
        }
        Assert.assertEquals(contor, expectedListIsbns.size());
    }
}
