package pageFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(xpath = "(//div[@class='attr-val'])[2]")
	WebElement selectSize;
	@FindBy(xpath = "//span[normalize-space()='add to cart']")
	WebElement clkAddToCart;
	@FindBy(xpath = "//div[@class='btn btn-theme-secondary open-cart']")
	WebElement clkViewCart;
	

	public void verifyCart() {
		
		ArrayList<String> bro=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(bro.size());
		//String  parent=bro.get(0);
		String  chield1=bro.get(1);
		driver.switchTo().window(chield1);
		
		Actions mouse=new Actions(driver);
		mouse.moveToElement(selectSize).click().perform();
		mouse.moveToElement(clkAddToCart).click().perform();

		this.clkViewCart.click();
		
	}

}
