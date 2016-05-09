package Tests;

import Pages.RozetkaLoginPage;
import SetUp.SetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by timoha on 19.04.2016.
 */
public class RozetkaLogin {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        SetUp setUp = new SetUp();
        driver = setUp.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        return new Object[][]{
                {"utes4all@gmail.com", "test12345", "testjavaqa"},
                //{"ramzes0987@mail.ru", "test12345", "Roman"}
        };
    }

    @Test(dataProvider = "credentials")
    public void RozetkaLogin(String userEmail, String userPassword, String expectedUserNameAfterLogin) throws InterruptedException {
        RozetkaLoginPage loginPage = new RozetkaLoginPage(driver);
        loginPage.login(userEmail, userPassword);
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.checkUserNameAfterLogin(expectedUserNameAfterLogin));
    }


    @Test(dataProvider = "credentials", dependsOnMethods = "RozetkaLogin")
    public void RozetkaLogOut() throws InterruptedException {
        RozetkaLoginPage loginPage = new RozetkaLoginPage(driver);
    }
}
