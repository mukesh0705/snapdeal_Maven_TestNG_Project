package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class ResultItemsPage {
	public WebDriver driver;
	public ResultItemsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void verifyResultPage() {
		SoftAssert softAssert = new SoftAssert();
		String actualHeader=driver.findElement(By.xpath("(//span[@class='nnn'])[1]")).getText();
		String expectedHeader="laptop bag";
		if (actualHeader.toLowerCase().contains(expectedHeader.toLowerCase())) {
			Reporter.log("Expected Search string is matched with actual string:: "+expectedHeader+"  "+actualHeader,true);
		} else {
			Reporter.log("Expected Search string is not matched with actual string:: "+expectedHeader+"  "+actualHeader,true);

		}
		//Hard Assertions(Assert)
		//Assert.assertEquals(actualHeader.toLowerCase(),expectedHeader.toLowerCase());
		//Soft Assertions (Verify)
		softAssert.assertEquals(actualHeader.toLowerCase(),expectedHeader.toLowerCase());
		//softAssert.assertAll();
	}
	
	public void itemlist() {
		List<WebElement> titleList=driver.findElements(By.xpath("//p[@class='product-title']"));
		List<WebElement> priceList=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for (int i = 0; i < titleList.size(); i++) {
			Reporter.log(i+1+"."+titleList.get(i).getText()+" \n\t======> Price "+priceList.get(i).getText(),true);
		}
		
		driver.findElement(By.xpath("(//p[@class='product-title'])[1]")).click();
		
	}

}

