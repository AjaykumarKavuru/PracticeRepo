package Com.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
	
	public static Properties prop;
	public static WebDriver driver;

	public void Initialization() throws IOException {
		prop = new Properties();
		FileInputStream fi = new FileInputStream("C:\\Users\\ajay7\\eclipse-workspace\\POM\\src\\main\\resources\\Config\\config.properties");
		prop.load(fi);
	}
	
	public void LaunchBrowser() {
		String Browser = prop.getProperty("browser");
		if(Browser.equals("Chrome")) {
			System.setProperty("Webdriver.chrome.driver", "C:\\Users\\ajay7\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(Browser.equals("Edge")){
			driver = new EdgeDriver();
		}	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
	}
}
