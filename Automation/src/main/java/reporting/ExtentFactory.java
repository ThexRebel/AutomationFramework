package reporting;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		String Path=System.getProperty("user.dir")+"\\Reports\\ExtentReportResults.html";
		ExtentReports extent;
		extent = new ExtentReports(Path,false);
		extent.addSystemInfo("System","Windows 11")
		.addSystemInfo("Seelenium","4.5");
		
		return extent;
	
	
	}
}
