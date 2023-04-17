package Mozammil.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import Mozammil.Automation.GeneralComponents.GeneralComponents;
import webDriver.BaseTest;

public class test2 extends BaseTest{

	
	@Test
	public void Testcase3() {
		System.out.println("Testcase3 Thread ID: "+Thread.currentThread().getId());
		//extra(getDriver());
		GeneralComponents gc3 = new GeneralComponents(getDriver());
		System.out.println("Testcase3 Thread ID: "+Thread.currentThread().getId());
		getDriver().get("http://www.google.com");
		getDriver().findElement(By.className("gLFyf")).clear();
		getDriver().findElement(By.className("gLFyf")).sendKeys("Selenium");
		getDriver().findElement(By.name("btnK")).click();
		System.out.println(gc3.waitForElement(By.className("B6fmyf"), 10));
		System.out.println("Testcase3 end Thread ID: "+Thread.currentThread().getId());
	}
	
	public void extra(WebDriver driver) {
		GeneralComponents gc = new GeneralComponents(driver);
		driver.get("http://www.google.com");
	    //Logger.info(LogStatus.PASS, "Google opened");
		driver.findElement(By.className("gLFyf")).sendKeys("Selenium");
		//Logger.info(LogStatus.PASS, "Selenium entered");
		driver.findElement(By.name("btnK")).click();
		//Logger.info(LogStatus.PASS, "Clicked on Search");
		//System.out.println(gc.waitForElement(By.className("srp EIlDfe"), 10));
		//Logger.info(LogStatus.PASS, "Validated");
	}
}
