package Frontend.Pages;

import Backend.RequestObject.RequestUser.RequestPostUser;
import net.bytebuddy.description.type.TypeDescription;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

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

    @FindBy(css="#delete-record-undefined")
    private List<WebElement> deleteBooks;

    @FindBy(css="#closeSmallModal-ok")
    private WebElement btnDeletePopUpOK;

    @FindBy(xpath = "//button[text()='Delete Account']")
    private WebElement btnDeleteAccount;


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
            }
        }
        Assert.assertEquals(contor, expectedListIsbns.size());
    }

    public void deleteRandomProfileBook(List<String> expectedListIsbns){
        //facem un random de pe o lista
        Integer index = getRandomIndexBook(expectedListIsbns.size());
        System.out.println(index);
        //logica de sus fara for
        element.clickElement(profileBooks.get(index));

        ProfileBookPage profileBookPage = new ProfileBookPage(driver);
        String expectedISBN = profileBookPage.getISBNValue();
        System.out.println(expectedISBN);
        profileBookPage.clickBackBtn();
        Assert.assertTrue(expectedListIsbns.contains(expectedISBN));

        //click pe btn Delete random din dreapta
        element.clickElement(deleteBooks.get(index));
        element.clickElement(btnDeletePopUpOK);

        alertsMethods.acceptAlert();

        //validam ca lista de pe web are -1 elemente
        Assert.assertTrue(expectedListIsbns.size()-1 == profileBooks.size());
    }

    private Integer getRandomIndexBook(Integer size){
        Random random = new Random();
        Integer index = random.nextInt(size);
        if(index.equals(size)){
            index--;
        }
        return index;
    }

    public void deleteAccount(){
        element.clickElement(btnDeleteAccount);
        element.clickElement(btnDeletePopUpOK);
        alertsMethods.acceptAlert();


    }
}
