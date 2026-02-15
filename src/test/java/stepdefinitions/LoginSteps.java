package stepdefinitions;


import base.BaseTest;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;



public class LoginSteps {
	LoginPage login;	

    @Given("User launches the application")
    public void launchApp() {
        BaseTest.initDriver();
        login = new LoginPage(BaseTest.driver);
    }

    @When("User clicks on login icon")
    public void clickLogin() {
        login.clickLoginIcon();
    }

    @When("User enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();
    }

    @Then("User should be logged in successfully")
    public void verifyLogin() {
        String title = BaseTest.driver.getTitle();
        Assert.assertTrue(title.contains("Advantage"));
        BaseTest.quitDriver();
    }
    }
