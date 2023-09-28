package config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AppUtil {
	
	public WebDriver driver;
	public Properties hello;
	
	@BeforeSuite
	public void setUp() throws Throwable {
		hello=new Properties();
		hello.load(new FileInputStream("I:\\OPPs_woekspace\\snapdeal_Maven_TestNG_Project\\propertyFile\\snapdeal.properties"));
		if (hello.getProperty("Browser").equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.snapdeal.com/");
		} else {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.snapdeal.com/");

		}
		
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
