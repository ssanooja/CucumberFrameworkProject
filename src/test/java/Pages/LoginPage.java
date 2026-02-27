package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[text() = 'Successfully Logged in...']")
    private WebElement successTitle;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void fillEmailData(String userName) {
        emailField.isEnabled();
        emailField.clear();
        emailField.sendKeys(userName);
    }

    public void fillPasswordData(String passWord) {
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys(passWord);
    }

    public void clickLoginButton() {
        loginButton.isEnabled();
        loginButton.click();
    }

    public String getLoginSuccessMessage() {
        successTitle.isDisplayed();
        return successTitle.getText();
    }
}
