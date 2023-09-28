package demo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) throws Throwable {
		//Handling Dynamic Web Tables Using Selenium WebDriver
		//ChromeOptions chromeOptions=new ChromeOptions();
		//WebDriverManager.chromedriver().driverVersion("116.0.5845.188").setup();
		//chromeOptions.addArguments("--headless");
		//ChromeDriver driver = new ChromeDriver(chromeOptions);
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		//number of column
		List<WebElement> col=driver.findElements(By.xpath("//div[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println(col.size());
		//number of rows
		List<WebElement> rows=driver.findElements(By.xpath("//div[@id='leftcontainer']/table/tbody/tr/td [1]"));
		System.out.println(rows.size());
		String text=driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[3]")).getText();
		System.out.println(text);
		List<WebElement> companiesName=driver.findElements(By.xpath("//div[@id='leftcontainer']/table/tbody/tr/td[1]"));
		
		for (int i = 0; i < companiesName.size(); i++) {
			String companiesList=companiesName.get(i).getText();
			System.out.println(companiesList);
			
		}
		//Fetch cell value of a particular row and column of the Dynamic Table
		WebElement baseTable=driver.findElement(By.tagName("table"));
		WebElement tableRow=baseTable.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[3]"));
		String rowText=tableRow.getText();
		System.out.println(rowText);
		WebElement cellNeed1=baseTable.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[3]/td[1]"));
		String cellText1=cellNeed1.getText();
		System.out.println(cellText1);
		WebElement cellNeed2=tableRow.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[3]/td[2]"));
		String cellText2=cellNeed2.getText();
		System.out.println(cellText2);
		TakesScreenshot screen=(TakesScreenshot)driver;
		File fi=screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fi,new File("I:\\OPPs_woekspace\\snapdeal_Maven_TestNG_Project\\screenShot\\scrShot.png"));

	}

}
