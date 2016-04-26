package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by timoha on 21.04.2016.
 */
public class RozetkaLoginPage {

    WebDriver driver;
    String baseUrl = "https://my.rozetka.com.ua/signin/";

    @FindBy(name = "login")
    WebElement userEmail;

    @FindBy(name = "password")
    WebElement userPassword;

    @FindBy(css = ".btn-link.btn-link-blue.btn-link-sign")
    WebElement submit;

    @FindBy(xpath = "html/body/header/div[2]/div/div[1]/div[1]/div[2]/span[2]/a")
    WebElement userNameLink;

    public RozetkaLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public void login(String userName, String password) {
        userEmail.sendKeys(userName);
        userPassword.sendKeys(password);
        submit.click();
    }

    public boolean checkUserNameAfterLogin(String expectedUserName) {
        System.out.println("Checking userName after login...");
        String actualUserName = userNameLink.getText();
        System.out.println("Actual userName: " + actualUserName);
        System.out.println("Expected userName: " + expectedUserName);
        if (expectedUserName.equalsIgnoreCase(actualUserName)) {
            System.out.println("Expected userName = Actual userName");
            return true;
        }
        return false;
    }
}
