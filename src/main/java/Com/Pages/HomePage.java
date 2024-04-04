package Com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.BaseTest.BaseTest;

public class HomePage extends BaseTest{
	
	@FindBy(xpath = "//img[@alt='client brand banner']")
	WebElement OrgHrmImg;
	
	@FindBy(xpath = "//ul[@class='oxd-main-menu']//li[2]")
	WebElement PIMBtn;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text--after'])[3]")
	WebElement Jobtitledropdown;
	@FindBy(xpath = "//span[text()='Chief Financial Officer']")
	WebElement JobtitleSelection;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean ImgValidation() {
		boolean flag = false;
		if(OrgHrmImg.isDisplayed()) {
			System.out.println("Orange Hrm tag is visible "+OrgHrmImg);
			flag = true;
		}
			return flag;
	}
	public void home() {
		PIMBtn.click();
		Jobtitledropdown.click();
		JobtitleSelection.click();
	}
	

	
}
