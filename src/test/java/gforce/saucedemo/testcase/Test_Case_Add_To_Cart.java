package gforce.saucedemo.testcase;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.InventoryPO;
import pageObjects.LoginPO;

public class Test_Case_Add_To_Cart extends BaseTest {
	WebDriver driver;
	LoginPO loginPage;
	InventoryPO inventoryPage;

	String username = "standard_user";
	String password = "secret_sauce";
	String firstItem = "Sauce Labs Backpack";
	String secondItem = "Sauce Labs Bike Light";
	String thirdItem = "Sauce Labs Bolt T-Shirt";
	@Parameters({"browser","url"})
	@BeforeTest
	public void initBrowserDriver(String browser, String url){
		log.info("Pre condition: Open Browser: " + browser + "and navigate to url:" + url);
		driver = getBrowserDriver(browser,url);
		log.info("Login to System");
		loginPage = new LoginPO(driver);
		inventoryPage = loginPage.logintoSystem(driver,username,password);
	}
	@Test(priority = 1)
	public void Add_A_Single_Item_To_Cart(){

		log.info("CLick to item "+firstItem);
		inventoryPage.clickAddToCart(firstItem);

		log.info("Is quantity increase to 1");
		String cartQty= inventoryPage.getCartQty();
		verifyEquals(cartQty,"1");

	}

	@Test(priority = 2)
	public void Add_Multiple_Items_To_Cart(){

		log.info("CLick to second item "+secondItem);
		inventoryPage.clickAddToCart(secondItem);

		String thirdItem = "Sauce Labs Bolt T-Shirt";
		log.info("CLick to third item "+thirdItem);
		inventoryPage.clickAddToCart(thirdItem);

		log.info("Is quantity increase to 3");
		String cartQty= inventoryPage.getCartQty();
		verifyEquals(cartQty,"3");

	}

	@Test(priority = 3)
	public void Verify_Empty_Item_To_Cart(){
		log.info("Remove all selected item added to cart");
		inventoryPage.clickAddToCart(thirdItem);
		inventoryPage.clickAddToCart(secondItem);
		inventoryPage.clickAddToCart(firstItem);

		log.info("Is Cart Quantity displayed");
		Boolean result = inventoryPage.isCartQtyDisplayed(driver);
		verifyTrue(result);
	}




}
