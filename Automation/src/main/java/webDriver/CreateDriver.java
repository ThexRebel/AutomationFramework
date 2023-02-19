package webDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDriver {
	static String browser="chrome";
	public static WebDriver driver;
	public static WebDriver Init() {
		return driver;
	}
	/*
	 * Browser Keyword:
	 * chrome
	 * chrome incognito
	 * chrome headless
	 * firefox
	 * firefox incognito
	 * firefox headless
	 * edge
	 * edge incognito
	 * edge headless
	 * ie
	 */
	@BeforeSuite
	public void createWebDriver() {
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().window().maximize();
		}
	}
	@AfterSuite
	public void close() throws InterruptedException {
		driver.quit();
	}
}
//https://stackoverflow.com/questions/49193864/how-to-use-the-same-browser-window-in-multiple-classes-using-testng-selenium-web