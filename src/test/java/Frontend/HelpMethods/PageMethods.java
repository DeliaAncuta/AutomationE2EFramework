package Frontend.HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageMethods {

   private WebDriver driver;

    public PageMethods(WebDriver driver) {
        this.driver = driver;
    }

    //metode la nivel de

    public void navigateToPage(String url){
        driver.navigate().to(url);
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.urlToBe(url));
    }

}
