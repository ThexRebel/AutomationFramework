package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected static 
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    @BeforeTest
    @Parameters("browser")
    public void Setup(String browser){
        //WebDriver driver = CreateDriver.createWebDriver(browser);
        //set driver
        threadLocalDriver.set(CreateDriver.createWebDriver(browser));

        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());

        
    }

    //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }


    @AfterTest
    public void tearDown(){
        getDriver().close();

        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());

        threadLocalDriver.remove();
    }

	 

}
