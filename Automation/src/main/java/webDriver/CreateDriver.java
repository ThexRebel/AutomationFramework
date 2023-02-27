package webDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDriver {
	//static String browser="chrome";
	
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
	public static WebDriver createWebDriver(String browser) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")){
			//WebDriverManager.chromedriver().setup();
		//	System.out.println(System.getProperty("user.dir"));
			String path =System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",path+"\\lib\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().window().maximize();
		}
		
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().window().maximize();
		}
		return driver;
	}
	
}
//https://stackoverflow.com/questions/49193864/how-to-use-the-same-browser-window-in-multiple-classes-using-testng-selenium-web