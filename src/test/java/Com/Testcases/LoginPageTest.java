package Com.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.BaseTest.BaseTest;
import Com.Pages.DataSet;
import Com.Pages.HomePage;
import Com.Pages.LoginPage;

public class LoginPageTest extends BaseTest {
	
	LoginPage loginpage;
	HomePage homepage;
	
//	public LoginPageTest() {
//		super();
//	}
	@BeforeMethod
	public void setup() throws IOException {
		Initialization();
		LaunchBrowser();
		loginpage = new LoginPage();
	}
	
	@Test(dataProviderClass = DataSet.class,dataProvider = "LoginData")
	public void LoginpageTestcase(String Username,String Password) throws IOException{
		homepage = loginpage.OrangHrmLogin(Username,Password);
	}
	
	@Test(priority = 1)
	public void TitleValidation() {
		String title = loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM","Title is not matched");
	}

	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
