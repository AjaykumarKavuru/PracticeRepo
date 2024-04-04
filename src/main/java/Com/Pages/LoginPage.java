package Com.Pages;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Com.BaseTest.BaseTest;

public class LoginPage extends BaseTest{
	
	

//Page Factory
	
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginBtn;
	
	public LoginPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage OrangHrmLogin(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
	}  
	
	
}
