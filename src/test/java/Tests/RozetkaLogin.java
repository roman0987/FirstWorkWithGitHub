package Tests;

import Pages.RozetkaLoginPage;
import Pages.RozetkaLogoutPage;
import SetUp.SetUp;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by timoha on 19.04.2016.
 */
public class RozetkaLogin {

    WebDriver driver;
    String expectedUserNameAfterLogin = "Roman";
    String exexpectedUserNameAfterLogout = "войдите в личный кабинет";
    String userEmail = "ramzes0987@mail.ru";
    String userPassword = "test12345";


    @Before
    public void setUp() {
        SetUp setUp = new SetUp();
        driver = setUp.getDriver();
    }

    @After
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

//    @Test
//    public void rozetkaLogout() throws InterruptedException {
//        RozetkaLogoutPage logoutPage = new RozetkaLogoutPage(driver);
//        RozetkaLoginPage loginPage = new RozetkaLoginPage(driver);
//        loginPage.login(userEmail, userPassword);
//        Thread.sleep(9000);
//        logoutPage.logout();
//        Thread.sleep(9000);
//        Assert.assertTrue(logoutPage.checkedUserNameAfterLogout(exexpectedUserNameAfterLogout));
//    }
}
