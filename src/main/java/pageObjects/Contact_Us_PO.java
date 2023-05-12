package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Global_vars;

import java.io.IOException;

public class Contact_Us_PO extends Base_PO {
    private @FindBy(how = How.XPATH, using = "//input[@name='first_name']")
    WebElement firstName_TextField;

    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName_TextField;

    private @FindBy(xpath = "//input[@name='email']")
    WebElement emailAddress_TextField;

    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement comment_TextField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submit_Button;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement successfulSubmission_Message_Text;

    public Contact_Us_PO() throws IOException {
        super();
    }

    public void navigateTo_WebDriverUniversity_Contact_Us_Page() throws IOException {
        navigateTo_URL(Global_vars.UniversityRegistration);
    }

    public void setUnique_FirstName() throws IOException {
        sendKeys(firstName_TextField, "AutoFN" + generateRandomNumber(5));
    }

    public void setUnique_LastName() throws IOException {
        sendKeys(lastName_TextField, "AutoLN" + generateRandomNumber(5));
    }

    public void setUnique_EmailAddress() throws IOException {
        sendKeys(emailAddress_TextField, "AutoEmail" + generateRandomNumber(10) + "@mail.com");
    }

    public void setUnique_Comment() throws IOException {
        sendKeys(comment_TextField, "Hello world " + generateRandomString(20));
    }

    public void setSpecific_FirstName(String firstName) throws IOException {
        sendKeys(firstName_TextField, firstName);
    }

    public void setSpecific_LastName(String lastName) throws IOException {
        sendKeys(lastName_TextField, lastName);
    }

    public void setSpecific_EmailAddress(String emailAddress) throws IOException {
        sendKeys(emailAddress_TextField, emailAddress);
    }

    public void setSpecific_Comment(String comment) throws IOException {
        sendKeys(comment_TextField, comment);
    }

    public void clickOn_Submit_Button() throws IOException {
        waitForWebElementAndClick(submit_Button);
    }

    public void validate_Successful_SubmissionMessage_Text() throws IOException {
        waitFor(successfulSubmission_Message_Text);
        Assert.assertEquals(successfulSubmission_Message_Text.getText(), "Thank You for your Message!");
    }
}
