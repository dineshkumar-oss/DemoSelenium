package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {


	WebDriver driver;
    WebDriverWait wait;
    
    By loader = By.cssSelector("div.loader");
    By user = By.id("menuUserLink");    
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.id("sign_in_btn");
	
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickLoginIcon() {

    	wait.until(driver -> 
        ((JavascriptExecutor) driver)
            .executeScript("return document.readyState")
            .equals("complete")
    );

   
    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

    
    try { Thread.sleep(1000); } catch (InterruptedException e) {}

    
    WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(user)
    );

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", element);
    }
             
   
    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
    	

        WebElement element = wait.until( ExpectedConditions.elementToBeClickable(loginBtn)
        );

        ((JavascriptExecutor) driver) .executeScript("arguments[0].click();", element);
    }
}