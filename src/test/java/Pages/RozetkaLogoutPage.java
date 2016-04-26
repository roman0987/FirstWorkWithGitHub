package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by timoha on 24.04.2016.
 */
public class RozetkaLogoutPage {

    WebDriver driver;
    String baseUrl = "https://my.rozetka.com.ua/signin/";

    @FindBy (name = "profile")
    WebElement userProfile;

    @FindBy (xpath = "html/body/header/div[2]/div/div[1]/div[1]/div[2]/span[2]/a")
    WebElement signout;

    public RozetkaLogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public void logout() {
        userProfile.click();
        signout.click();
    }

    public boolean checkedUserNameAfterLogout(String expectedUserName) {
        String actualUserName = userProfile.getText();
        System.out.println("Checking userName after logout...");
        System.out.println("Actual userName: " + actualUserName);
        System.out.println("Expected userName: " + expectedUserName);
        if (actualUserName.equalsIgnoreCase(expectedUserName)){
            System.out.println("Expected userName = Actual userName");
            return true;
        }
        return false;
    }
}
