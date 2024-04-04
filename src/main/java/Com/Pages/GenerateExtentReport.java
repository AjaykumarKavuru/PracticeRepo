package Com.Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateExtentReport {
	
	ExtentSparkReporter extentsparkreporter;
	ExtentReports extentreport;
	ExtentTest extenttest;

	public void StartReport() {
		extentreport = new ExtentReports();
		extentsparkreporter = new ExtentSparkReporter("C:\\Users\\ajay7\\eclipse-workspace\\POM\\target");
		extentreport.attachReporter(extentsparkreporter);
		
		extentreport.flush();
	}
}
