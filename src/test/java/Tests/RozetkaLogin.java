package Tests;

import Pages.RozetkaLoginPage;
import SetUp.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by timoha on 19.04.2016.
 */
public class RozetkaLogin {

    WebDriver driver;
    String expectedUserName = "войдите в личный кабинет";

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
                {"ramzes0987@mail.ru", "test12345", "Roman"}
        };
    }

    @Test(dataProvider = "credentials")
    public void RozetkaLogin(String userEmail, String userPassword, String expectedUserNameAfterLogin) throws InterruptedException {
        RozetkaLoginPage loginPage = new RozetkaLoginPage(driver);
        loginPage.login(userEmail, userPassword);
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.checkUserNameAfterLogin(expectedUserNameAfterLogin));
    }


//    @Test(dependsOnMethods = "RozetkaLogin")
//    public void RozetkaLogOut() throws InterruptedException {
//        driver.findElement(By.cssSelector(".header-user-link.sprite-side.novisited.xhr")).click();
//        Thread.sleep(1000);
//        System.out.println("Click name");
//        driver.findElement(By.cssSelector(".header-popup-header-user-i-link.sprite-side.novisited.xhr")).click();
//        Thread.sleep(5000);
//        System.out.println("Click Exit");
//        String userNameAfterLogOut = driver.findElement(By.cssSelector(".header-user-link.sprite-side.novisited.xhr")).getText();
//        Assert.assertTrue(expectedUserName.equalsIgnoreCase(userNameAfterLogOut));
//    }
}
