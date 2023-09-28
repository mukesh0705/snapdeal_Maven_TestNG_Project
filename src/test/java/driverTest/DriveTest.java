package driverTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import config.AppUtil;
import pageFactory.AddToCart;
import pageFactory.CartPage;
import pageFactory.FrontPage;
import pageFactory.ResultItemsPage;
import pageFactory.SingleItemPage;


public class DriveTest extends AppUtil {
	
	@Test(priority = 0)
	public void search() {
		//FrontPage fr=PageFactory.initElements(driver, FrontPage.class);
		FrontPage fr=new FrontPage(driver);
		fr.fopage("sport shoe for men");
	}
	@Test(priority = 1)
	public void resultItems() {
		ResultItemsPage res=new ResultItemsPage(driver);
		res.itemlist();
		res.verifyResultPage();
	}
	@Test(priority = 2)
	public void pickedItem() throws Throwable {
		SingleItemPage sin=new SingleItemPage(driver);
		sin.verifyClickedItem01();
		
	}
	@Test(priority = 3)
	public void addCart() throws Throwable {
		
		//CartPage cartPage=new CartPage(driver);
		CartPage cartPage=PageFactory.initElements(driver, CartPage.class);
		cartPage.verifyCart();
	}
	@Test(priority = 4,enabled = false)
	public void cart() throws Throwable {
		AddToCart kartPage=PageFactory.initElements(driver, AddToCart.class);
		kartPage.addCart();
	}
	

}
