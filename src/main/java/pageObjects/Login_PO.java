package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_vars;

import java.io.IOException;

public class Login_PO extends Base_PO {
    private @FindBy(id = "text")
    WebElement username_TextField;

    private @FindBy(id = "password")
    WebElement password_TextField;

    private @FindBy(id = "login-button")
    WebElement login_Button;

    public Login_PO() throws IOException {
        super();
    }

    public void navigateTo_WebDriverUniversity_Login_Page() throws IOException {
        navigateTo_URL(Global_vars.UniversityLogin);
    }

    public void setUsername(String username) throws IOException {
        sendKeys(username_TextField, username);
    }

    public void setPassword(String password) throws IOException {
        sendKeys(password_TextField, password);
    }

    public void clickOn_Login_Button() throws IOException {
        waitForWebElementAndClick(login_Button);
    }

    public void validate_SuccessfulLogin_Message() throws IOException {
        waitForAlert_And_ValidateText("validation succeeded");
    }

    public void validate_UnsuccessfulLogin_Message() throws IOException {
        waitForAlert_And_ValidateText("validation failed");
    }
}
