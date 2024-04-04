package Com.Testcases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.BaseTest.BaseTest;
import Com.Pages.DataSet;
import Com.Pages.LoginPage;
import Com.Pages.Trial;

public class TrialTest extends BaseTest{
	
	ExtentSparkReporter extentsparkreporter;
	ExtentReports extentreport;
	LoginPage loginpage;

@BeforeTest
public void StartReport() {
	extentreport = new ExtentReports();
	extentsparkreporter = new ExtentSparkReporter("C:\\Users\\ajay7\\eclipse-workspace\\POM\\target\\report\\report.html");
	extentreport.attachReporter(extentsparkreporter);
}

@BeforeMethod
public void setup() throws IOException {
	Initialization();
	LaunchBrowser();
	loginpage = new LoginPage();
}

@Test(dataProviderClass = DataSet.class,dataProvider = "LoginData")
public void TrialLoginTest(String username, String password) {
	Trial trial = new Trial();
	trial.HomePageLogin(username, password);
	System.out.println("Excel validation done successfully");
}

@Test
public void TitleValidation() {
	String title = loginpage.ValidateLoginPageTitle();
	Assert.assertEquals(title, "OrangeHRM","Title is not matched");
}

//@Test
//public void test() {
//	System.out.println("hi");
//	String Path = System.getProperty("user.dir")+"\\src\\main\\resources\\DataFiles\\OrageHrm_TestData.xlsx";
//System.out.println(Path);
//}

@AfterMethod
public void teardown() {
	driver.close();
}

@AfterTest
public void endreport() throws IOException {
	extentreport.flush();
   }
}
