package Mozammil.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Mozammil.Automation.GeneralComponents.GeneralComponents;
import reporting.Logger;
import webDriver.CreateDriver;

public class test {
	GeneralComponents gc = new GeneralComponents();
	
	@Test(priority = 1)
	public void Testcase1() {
		Logger.startLogForTestCase("Testcase1");
		gc.open("http://www.google.com");
		Logger.info(LogStatus.PASS, "Google opened");
		CreateDriver.Init().findElement(By.className("gLFyf")).sendKeys("Selenium");
		Logger.info(LogStatus.PASS, "Selenium entered");
		CreateDriver.Init().findElement(By.name("btnK")).click();
		Logger.info(LogStatus.PASS, "Clicked on Search");
		System.out.println(gc.waitForElement(By.className("SPZz6b"), 10));
		Logger.info(LogStatus.PASS, "Validated");
	}
	
	@Test(priority = 2)
	public void Testcase2() {
		Logger.startLogForTestCase("Tstcase2");
		gc.open("http://www.google.com");
		Logger.info(LogStatus.PASS, "2 Google opened");
		CreateDriver.Init().findElement(By.className("gLFyf")).sendKeys("Selenium");
		Logger.info(LogStatus.PASS, "2 Selenium entered");
		CreateDriver.Init().findElement(By.name("btnK")).click();
		Logger.info(LogStatus.PASS, "2 Clicked on Search");
		System.out.println(gc.waitForElement(By.className("SPZz6b"), 10));
		Logger.info(LogStatus.PASS, "2 Validated");
	}
	
}



/*
test.log(LogStatus.PASS,"Test Passed");
test.log(LogStatus.FAIL,"Test Failed");
test.log(LogStatus.SKIP,"Test Skipped");
test.log(LogStatus.INFO,"Test Info");
*/