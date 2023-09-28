package pageFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AddToCart {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	public AddToCart(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(xpath = "//input[@id='pincode-value']")
	WebElement pinNo;
	@FindBy(xpath = "//a[@id='send-pincode']")
	WebElement clkPin;
	@FindBy(xpath = "//span[strat-with(@class,'item-subtotal-black')]")
	WebElement totalPrice;
	@FindBy(id = "CS1")
	WebElement select;
	@FindBy(xpath = "//*[@rel='3']")
	WebElement selList;
	
	public void addCart() throws Throwable {
		
		wait=new WebDriverWait(driver, 30);
		js=(JavascriptExecutor)driver;
		
		
		
		//Select quantity=new Select(sel);
		//quantity.selectByIndex(3);
		
		wait.until(ExpectedConditions.visibilityOf(select));
		this.select.click();
		wait.until(ExpectedConditions.visibilityOf(selList));
		this.selList.click();
		wait.until(ExpectedConditions.visibilityOf(pinNo));
		this.pinNo.sendKeys("500038");
		this.clkPin.click();
		
		wait.until(ExpectedConditions.visibilityOf(totalPrice));
		String tPrice=this.totalPrice.getText();
		Reporter.log(tPrice,true);
		
		
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("I:/OPPs_woekspace/snapdeal_Maven_TestNG_Project/screenShot/scr.jpg"));
	}

}
