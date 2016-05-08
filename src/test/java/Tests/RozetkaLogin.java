package Tests;

import Pages.RozetkaLoginPage;
import SetUp.SetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by timoha on 19.04.2016.
 */
public class RozetkaLogin {

    WebDriver driver;
    String expectedUserNameAfterLogin = "Roman";
    String userEmail = "ramzes0987@mail.ru";
    String userPassword = "test12345";


    @BeforeMethod
    public void setUp() {
        SetUp setUp = new SetUp();
        driver = setUp.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void rozetkaLogin() throws InterruptedException {
        RozetkaLoginPage loginPage = new RozetkaLoginPage(driver);
        loginPage.login(userEmail, userPassword);
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.checkUserNameAfterLogin(expectedUserNameAfterLogin));
    }
}
