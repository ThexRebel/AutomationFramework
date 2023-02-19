package reporting;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Logger {
	static ExtentTest test;
	static ExtentReports report;
	public static void info(LogStatus status,String details) {
		test.log(status, details);
	}
	public static void startLogForTestCase(String TestCaseName)
	{
		test = report.startTest(TestCaseName);
	}
	@BeforeTest
	public static void startLogger()
	{
		String name="ExtentReportResults"+System.currentTimeMillis()+".html";
		report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\"+name);
		//test = report.startTest("Test");
	}
	
	@AfterTest
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}
}
/*
test.log(LogStatus.PASS,"Test Passed");
test.log(LogStatus.FAIL,"Test Failed");
test.log(LogStatus.SKIP,"Test Skipped");
test.log(LogStatus.INFO,"Test Info");
*/