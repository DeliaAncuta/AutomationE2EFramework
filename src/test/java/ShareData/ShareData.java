package ShareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShareData {


    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }




    public void setupChrome(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");

        driver = new ChromeDriver();


        driver.manage().window().maximize();

        driver.get("https://demoqa.com/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //Folosim @After pt a iunchide driver-ul

    public void clearBrowser(){

        driver.quit();
    }

}
