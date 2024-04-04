package Com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Com.BaseTest.BaseTest;

public class Trial extends BaseTest{

	WebElement Username = driver.findElement(By.name("username"));
	WebElement Password = driver.findElement(By.name("password"));
	WebElement LoginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
	
	public void HomePageLogin(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		LoginBtn.click();
	}
}
