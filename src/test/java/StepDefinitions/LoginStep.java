package StepDefinitions;

import Drivers.DriverManager;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.JsonUtil;

public class LoginStep {
    WebDriver driver;
    LoginPage loginPage;

    @Given("Login page is displayed using {string}")
    public void loginPageIsDisplayedUsing(String url) {
        driver = DriverManager.getDriver();
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @When("Enter username {string} and password {string}")
    public void enterUsernameAndPassword(String userName, String passWord) {
        loginPage.fillEmailData(userName);
        loginPage.fillPasswordData(passWord);
    }

    @And("Click Login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Successful login page will display")
    public void successfulLoginPageWillDisplay() {
        String actualLoginSuccessMsg = loginPage.getLoginSuccessMessage();
        Assert.assertEquals(actualLoginSuccessMsg,"Successfully Logged in...");
    }

    // This is related to BDD with Data-Driven
    @Given("user logs in using data {string}")
    public void userLoginWithValidData(String userType) {
        driver = DriverManager.getDriver();

        String url = JsonUtil.get(userType, "url");
        String username = JsonUtil.get(userType, "username");
        String password = JsonUtil.get(userType, "password");

        driver.get(url);

        loginPage = new LoginPage(driver);
        loginPage.fillEmailData(username);
        loginPage.fillPasswordData(password);
        loginPage.clickLoginButton();
    }

    @Then("Error message should be displayed")
    public void errorWillDisplay() {
        String actualLoginSuccessMsg = loginPage.getLoginSuccessMessage();
        Assert.assertEquals(actualLoginSuccessMsg,"Successfully Logged in...");
    }
}
