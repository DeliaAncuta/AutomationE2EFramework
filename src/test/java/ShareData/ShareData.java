package ShareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShareData {

    //driver ul cea mai imp resusrsa si din acest motiv il incapsulam;
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    //folosim adnotarea de @Before din testNG


    public void setupChrome(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        //Deschidem un browser de chrome
        driver = new ChromeDriver();

        //Facem driver ul mare
        driver.manage().window().maximize();

        //Accesam un URl specific - metoda get asteapta ca pagina sa se incarce
        driver.get("https://demoqa.com/login");

        //Wait implicit - pt imbunatatirea codului
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //asteapta maxim 10 secunde
        // /vegheaza asupra liniilor de tip findelement - daca nu gaseste in 10 seunda da eroare
        // daca se incarca mai devreme nici nu se activeaza acest wait

        //Wait Explicit - doar acolo unde exista o problema -  poti sa i dai o conditie pt care sa astepte - am implementat in FrameTest


    }

    //Folosim @After pt a iunchide driver-ul

    public void clearBrowser(){

        driver.quit();
        // driver.quit - ca sa inchidem browser ul - NU cu close
        // driver. quit = inchide browser ul cu oricate taburi deschide are
        // driver.quit = inchide tab ul curent DOAR
    }

}
