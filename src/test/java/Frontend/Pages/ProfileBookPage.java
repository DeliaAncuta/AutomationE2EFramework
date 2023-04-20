package Frontend.Pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileBookPage extends BasePage {
    public ProfileBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#ISBN-wrapper #userName-value")
    private WebElement isbnElement;

    @FindBy(css="#addNewRecordButton")
    private WebElement btnBackToBookStore;

    public String getISBNValue(){
       element.waitElementVisible(isbnElement);
       return isbnElement.getText();
    }

    public void clickBackBtn(){
        element.scrollByPixel(0, 500);
        element.clickElement(btnBackToBookStore);
    }
}
