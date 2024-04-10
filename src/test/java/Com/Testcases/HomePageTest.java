package Com.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.BaseTest.BaseTest;
import Com.Pages.ExcelUtilities;
import Com.Pages.HomePage;
import Com.Pages.LoginPage;

public class HomePageTest extends BaseTest{
	
LoginPage loginpage;
HomePage homepage;
	
	@BeforeMethod
	public void setup() throws IOException {
		Initialization();
		LaunchBrowser();
		loginpage = new LoginPage();
		homepage = new HomePage();
//		loginpage.OrangHrmLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
//	@Test(priority = 1)
//	public void HomePageTestImgVal() {
//		boolean status = homepage.ImgValidation();
//		Assert.assertEquals(status, true,"Image validation failed");
//	}
//	@Test(priority = 2)
//	public void HomePageTestVal() {
//		homepage.home();
//	}
	
	@Test
	public void ExcelValidation() throws IOException {
		String Path = "C:\\Users\\ajay7\\eclipse-workspace\\POM\\src\\"
				+ "main\\resources\\DataFiles\\TrailData.xlsx";
		ExcelUtilities extrautil = new ExcelUtilities(Path);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
