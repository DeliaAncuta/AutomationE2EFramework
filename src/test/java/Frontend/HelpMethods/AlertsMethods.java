package Frontend.HelpMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsMethods {
    private WebDriver driver;

    public AlertsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert(){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert(){
        waitAlert();
        Alert dismiss = driver.switchTo().alert();
        dismiss.accept();
    }

    public void fillAlert(String value, Boolean makeDecision){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        if(makeDecision){
            alert.accept();
        }
        else{
            alert.dismiss();
        }
    }

    private void waitAlert(){
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
    }
}
