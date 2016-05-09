package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by timoha on 09.05.2016.
 */
public class RozetkaLogOutPage {

    @FindBy(css = "#profile_signout")
    WebElement logOut;

    @FindBy(xpath = ".//*[@id='header_user_menu_parent']/a")
    WebElement userNameLink;

    public void logOut() {
        logOut.click();
    }

    public boolean checkUserNameAfterLogOut(String expectedUserName) {
        String nameText = userNameLink.getText();
        if (expectedUserName.equalsIgnoreCase(nameText)) {
            return true;
        }
        return false;
    }


}
