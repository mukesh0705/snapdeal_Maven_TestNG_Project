package pageFactory;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TicToc {
	
    static JavascriptExecutor js;
    
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.xpath("//input[@id='inputValEnter']")).sendKeys("Sport shoes");
		js=(JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\".sd-icon.sd-icon-search-under-catagory.lfloat\").click()");
		//driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
		driver.findElement(By.xpath("(//p[@class='product-title'])[1]")).click();
		
		ArrayList<String> bro=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(bro.size());
		//String  parent=bro.get(0);
		String  chield1=bro.get(1);
		driver.switchTo().window(chield1);
		
		
		
		Actions mouse=new Actions(driver);
		mouse.click(driver.findElement(By.xpath("(//div[@class='attr-val'])[2]"))).perform();
		mouse.click(driver.findElement(By.xpath("//span[normalize-space()='add to cart']"))).perform();
		mouse.click(driver.findElement(By.xpath("//div[@class='btn btn-theme-secondary open-cart']"))).perform();
		
		/*WebElement modalContainer = driver.findElement(
                By.className("modal-box-dialog in"));
		WebElement selectBtn=modalContainer.findElement(By.xpath("//select[@data-catalogid='667304226407']"));
		selectBtn.click();*/
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Pincode']")).sendKeys("500035");
		Thread.sleep(5000);
		//WebElement dropDown=driver.findElement(By.xpath("//*[@data-ul='cart-dropdown']"));
		//
		//Select hello=new Select(dropDown);
		//hello.deselectAll();

		driver.findElement(By.id("CS1")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@rel='3']")).click();
		Thread.sleep(3000);
		String str=driver.findElement(By.xpath("//span[@class='item-subtotal-black']")).getText();
		System.out.println(str);

		//hello.selectByVisibleText("3");//
        
		
	}

}
