package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 public static WebDriver driver;

	    public static void initDriver() {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.get("https://advantageonlineshopping.com/");
	    }

	    public static void quitDriver() {
	        driver.quit();
	    }
}
