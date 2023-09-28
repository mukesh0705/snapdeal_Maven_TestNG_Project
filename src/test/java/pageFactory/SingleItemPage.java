package pageFactory;

import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class SingleItemPage {

	public WebDriver driver;
	public SingleItemPage(WebDriver driver) {
		this.driver=driver;
	}

	public void verifyClickedItem01() {
		SoftAssert softAssert=new SoftAssert();
		String beforeClickItemTitle=driver.findElement(By.xpath("(//p[@class='product-title'])[1]")).getText();

		String mainWindow=driver.getWindowHandle();
		Set<String> win=driver.getWindowHandles();
		Iterator<String> itr=win.iterator();
		int in=win.hashCode();
		//System.out.println(in);
		

		/*while(itr.hasNext()){
			String childWindow=itr.next();
			// Compare whether the main windows is not equal to child window. If not equal, we will close.
			if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());

			}
		}*/
		ArrayList<String> bro=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(bro.size());
		//String  parent=bro.get(0);
		String  chield1=bro.get(1);
		driver.switchTo().window(chield1);
		String afterClickItemTitle=driver.findElement(By.xpath("//h1[@class='pdp-e-i-head']")).getText();


		if (afterClickItemTitle.toLowerCase().contains(beforeClickItemTitle.toLowerCase())) {
			Reporter.log("clicked item verified:: "+beforeClickItemTitle+"====>"+afterClickItemTitle,true);
		} else {
			Reporter.log("clicked item not verified:: "+beforeClickItemTitle+"====>"+afterClickItemTitle,true);
		}
		softAssert.assertEquals(afterClickItemTitle, beforeClickItemTitle);
		softAssert.assertAll("clicked item not verified:: "+beforeClickItemTitle+"====>"+afterClickItemTitle);
		
		

	}
	

}
//work on negative things in testing like.....if you found any bug then what's your next step.
