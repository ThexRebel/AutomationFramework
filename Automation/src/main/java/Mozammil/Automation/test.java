package Mozammil.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import Mozammil.Automation.GeneralComponents.GeneralComponents;
import reporting.TestListener;
import webDriver.BaseTest;

public class test extends BaseTest{
	@Test
	public void print() {
		TestListener itl = new TestListener();
		System.out.println("Hello!");
		System.out.println("Testcase1 Thread ID: "+Thread.currentThread().getId());
	}
	
	@Test(priority = 1)
	public void Testcase1() {
		try {
		GeneralComponents gc1 = new GeneralComponents(getDriver());
		 System.out.println("Testcase1 Thread ID: "+Thread.currentThread().getId());
		gc1.open("http://www.google.com");
		getDriver().findElement(By.className("gLFyf")).clear();
		getDriver().findElement(By.className("gLFyf")).sendKeys("Selenium");
		getDriver().findElement(By.name("btnK")).click();
		System.out.println(gc1.waitForElement(By.className("B6fmyf"), 10));
		 System.out.println("Testcase1 end Thread ID: "+Thread.currentThread().getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void Testcase2() {
		try {
			GeneralComponents gc2 = new GeneralComponents(getDriver());
			gc2.waitForSpecifiedTime(3);
			System.out.println("Testcase2 Thread ID: "+Thread.currentThread().getId());
			//Logger.startLogForTestCase("Tstcase2");
			gc2.open("http://www.google.com");
			getDriver().findElement(By.className("gLFyf")).clear();
			//Logger.info(LogStatus.PASS, "2 Google opened");
			getDriver().findElement(By.className("gLFyf")).sendKeys("Selenium");
			//Logger.info(LogStatus.PASS, "2 Selenium entered");
			getDriver().findElement(By.name("btnK")).click();
			//Logger.info(LogStatus.PASS, "2 Clicked on Search");
			System.out.println(gc2.waitForElement(By.className("B6fmyf"), 10));
			//Logger.info(LogStatus.PASS, "2 Validated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}



/*
test.log(LogStatus.PASS,"Test Passed");
test.log(LogStatus.FAIL,"Test Failed");
test.log(LogStatus.SKIP,"Test Skipped");
test.log(LogStatus.INFO,"Test Info");
*/