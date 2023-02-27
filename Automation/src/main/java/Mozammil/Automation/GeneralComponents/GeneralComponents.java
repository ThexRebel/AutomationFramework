package Mozammil.Automation.GeneralComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import webDriver.CreateDriver;

public class GeneralComponents {
	public static WebDriver Driver;
	public GeneralComponents(WebDriver driver) {
		Driver=driver;
	}
	public static WebDriver getCurrentDriver() {
		return Driver;
	}
	
	public static void open(String url) {
		getCurrentDriver().get(url);
	}
	public static void waitForSpecifiedTime(int seconds) {
		try {
			int waitTime=seconds*1000;
			Thread.sleep(waitTime);
		}
		catch(Exception e) {
			
		}
	}
	
	public static boolean waitForElement(String xpath,int time)  {
		
		WebElement ele = getCurrentDriver().findElement(By.xpath(xpath));
		return waitForElement(ele, time) ;
	}
	
	public static boolean waitForElement(By by,int time)  {
		WebElement ele = getCurrentDriver().findElement(by);
		return waitForElement(ele, time) ;
	}
	
	public static boolean waitForElement(WebElement ele,int time)  {
		long currTime = System.currentTimeMillis();
		long waitTill = currTime+time;
		
		while(currTime<waitTill) {
			if(ele.isDisplayed()) {
				return true;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			currTime = System.currentTimeMillis();
		}
		return false;
	}
	 
}
