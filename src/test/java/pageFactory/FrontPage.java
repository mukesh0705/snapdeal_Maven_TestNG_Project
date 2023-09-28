package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrontPage {
	
	public WebDriver driver;
	public FrontPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void fopage(String searchKey) {
		
		driver.findElement(By.xpath("//input[@id='inputValEnter']")).sendKeys(searchKey);
		driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
			
	}

}
