package Frontend.Pages;

import Frontend.HelpMethods.AlertsMethods;
import Frontend.HelpMethods.ElementMethods;
import Frontend.HelpMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;

    public ElementMethods element;
    public PageMethods pageMethods;
    public AlertsMethods alertsMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        element = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        alertsMethods = new AlertsMethods(driver);
    }

}
