package Frontend.HelpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethods {

    private WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    //Facem metode generale pentru intereactiunle cu elementele - pt actiuni asupra elementelor


    //Metoda sa faca click
    public void clickElement(WebElement element){
        waitElementVisible(element);
        element.click();
    }

    public void forceWait(int value){
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Metoda sa astepte
    public void waitElementVisible(WebElement element){
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.visibilityOf(element));
    }

    //Metoda sendkeys
    public void fillElement(WebElement element, String value){
        waitElementVisible(element);
        element.sendKeys(value);
    }

    //Metoda de validare
    public void validateElementText(WebElement element, String value){
        waitElementVisible(element); //am chemat metoda de wait exxplicit
        String actualValue = element.getText();
        Assert.assertEquals(value, actualValue);
    }

    //metoda de selectare
    public void SelectElementText(WebElement element, String value){
        waitElementVisible(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByVisibleText(value);

    }

    public void SelectElementValue(WebElement element, String value){
        waitElementVisible(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByValue(value);

    }

    public void scrollByPixel(Integer x, Integer y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")"); //de fapt are nevoie de String asa ca concatenam integer in string

    }

    public void moveToElement(WebElement element){
        waitElementVisible(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }


}
