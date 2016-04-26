package SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by timoha on 21.04.2016.
 */
public class SetUp {

    WebDriver driver;
    String baseUrl = "https://my.rozetka.com.ua/signin/";

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
