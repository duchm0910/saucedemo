package gforce.saucedemo.testcase;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.CartPO;
import pageObjects.InventoryPO;
import pageObjects.LoginPO;

public class Test_Case_Purchase extends BaseTest {
	WebDriver driver;
	LoginPO loginPage;
	InventoryPO inventoryPage;
	CartPO cartPage;

	String username = "standard_user";
	String password = "secret_sauce";
	String firstItem = "Sauce Labs Backpack";
	String secondItem = "Sauce Labs Bike Light";
	String thirdItem = "Sauce Labs Bolt T-Shirt";

	String checkOutBtn = "Checkout";
	String continueShoppingBtn = "Continue Shopping";
	String cancelBtn = "Cancel";
	String finishBtn = "Finish";
	String backHomeBtn = "Back Home";

	String youtCartTitle = "YOUR CART";
	String yourInfoTitle = "CHECKOUT: YOUR INFORMATION";
	String overviewTitle = "CHECKOUT: OVERVIEW";
	String completeTitle = "CHECKOUT: COMPLETE!";
	String firstName, lastName, postalCode;

	@Parameters({"browser", "url"})
	@BeforeTest
	public void initBrowserDriver(String browser, String url) {
		log.info("Pre condition: Open Browser: " + browser + "and navigate to url:" + url);
		driver = getBrowserDriver(browser, url);

		log.info("Login to System");
		loginPage = new LoginPO(driver);
		inventoryPage = loginPage.logintoSystem(driver, username, password);
	}

	@Test(priority = 1)
	public void Add_One_Item_And_Check_Out_Success() {

		log.info("Step 1: Add item " + firstItem + " to cart");
		inventoryPage.clickAddToCart(firstItem);

		log.info(" Step 2: Click to Cart button");
		cartPage = inventoryPage.clickCartButton();

		log.info("Is Your Card page displayed");
		String expectTitle = cartPage.getTitleText();
		String actualTitle = youtCartTitle;
		verifyEquals(expectTitle, actualTitle);

		log.info("Check selected item is displayed in cart");
		String actualItem = cartPage.getItemInCartText();
		String expectedItem = firstItem;
		verifyEquals(actualItem, expectedItem);

		log.info("Step 3: Click Checkout button");
		cartPage.clickActionButton(checkOutBtn);

		log.info("Is checkout step 1 displayed");
		expectTitle = cartPage.getTitleText();
		actualTitle = yourInfoTitle;
		verifyEquals(expectTitle, actualTitle);

		log.info("Step 4: Input check out information");
		firstName = "John";
		lastName = "Doe";
		postalCode = "70000";
		cartPage.inputCheckOutInformation(driver, firstName, lastName, postalCode);

		log.info("Step 5: Click Continue button");
		cartPage.clickContinueButton();

		log.info("Is checkout step 2 displayed");
		expectTitle = cartPage.getTitleText();
		actualTitle = overviewTitle;
		verifyEquals(expectTitle, actualTitle);


		log.info("Step 6: Click Finish button");
		cartPage.clickActionButton(finishBtn);

		log.info("Is checkout Complete page displayed");
		expectTitle = cartPage.getTitleText();
		actualTitle = completeTitle;
		verifyEquals(expectTitle, actualTitle);



	}

//	@Test(priority = 2)
//	public void Add_Multiple_Items_To_Cart(){
//
//		log.info("CLick to second item "+secondItem);
//		inventoryPage.clickAddToCart(secondItem);
//
//		String thirdItem = "Sauce Labs Bolt T-Shirt";
//		log.info("CLick to third item "+thirdItem);
//		inventoryPage.clickAddToCart(thirdItem);
//
//		log.info("Is quantity increase to 3");
//		String cartQty= inventoryPage.getCartQty();
//		verifyEquals(cartQty,"3");
//
//	}
//
//	@Test(priority = 3)
//	public void Verify_Empty_Item_To_Cart(){
//		log.info("Remove all selected item added to cart");
//		inventoryPage.clickAddToCart(thirdItem);
//		inventoryPage.clickAddToCart(secondItem);
//		inventoryPage.clickAddToCart(firstItem);
//
//		log.info("Is Cart Quantity displayed");
//		Boolean result = inventoryPage.isCartQtyDisplayed(driver);
//		verifyTrue(result);
//	}




}
