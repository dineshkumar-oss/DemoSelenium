package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import pages.LoginPage;
import utilities.DriverFactory;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user launches the application")
    public void user_launches_the_application() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should be navigated to home page")
    public void user_should_be_navigated_to_home_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}