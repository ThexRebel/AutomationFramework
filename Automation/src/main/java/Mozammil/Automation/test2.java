package Mozammil.Automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Mozammil.Automation.GeneralComponents.GeneralComponents;
import reporting.Logger;
import webDriver.CreateDriver;

public class test2 {
GeneralComponents gc = new GeneralComponents();
	
	@Test(priority = 1)
	public void Testcase3() {
		Logger.startLogForTestCase("Testcase3");
		gc.open("http://www.google.com");
		Logger.info(LogStatus.PASS, "Google opened");
		CreateDriver.Init().findElement(By.className("gLFyf")).sendKeys("Selenium");
		Logger.info(LogStatus.PASS, "Selenium entered");
		CreateDriver.Init().findElement(By.name("btnK")).click();
		Logger.info(LogStatus.PASS, "Clicked on Search");
		System.out.println(gc.waitForElement(By.className("SPZz6b"), 10));
		Logger.info(LogStatus.PASS, "Validated");
	}
}
