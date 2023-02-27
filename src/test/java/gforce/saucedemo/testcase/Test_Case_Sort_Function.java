package gforce.saucedemo.testcase;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.InventoryPO;
import pageObjects.LoginPO;

import java.util.Collections;
import java.util.List;

public class Test_Case_Sort_Function extends BaseTest {
	WebDriver driver;
	LoginPO loginPage;
	InventoryPO inventoryPage;

	String username = "standard_user";
	String password = "secret_sauce";

	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowserDriver(String browser, String url){
		log.info("Pre condition: Open Browser: " + browser + "and navigate to url:" + url);
		driver = getBrowserDriver(browser,url);
//		log.info("Login to System");
//		loginPage = new LoginPO(driver);
//		inventoryPage = loginPage.logintoSystem(driver,username,password);

	}

	@Test(priority = 1)
	public void Sort_01_Name(){
		log.info("Login to System");
		loginPage = new LoginPO(driver);
		inventoryPage = loginPage.logintoSystem(driver,username,password);


		String sortNameAZ = "Name (A to Z)";
		String sortNameZA = "Name (Z to A)";

		log.info("Select sort from drop down with "+ sortNameAZ);
		inventoryPage.selectItemInDropdown(sortNameAZ);
		log.info("Compare the name after sort is equal");
		verifyTrue(inventoryPage.isProductNameSortAscending());

		log.info("Select sort from drop down with "+ sortNameZA);
		inventoryPage.selectItemInDropdown(sortNameZA);

		log.info("Compare the name after sort is equal");
		verifyTrue(inventoryPage.isProductNameSortDescending());
	}

	@Test(priority = 2)
	public void Sort_02_Price(){
		String sortPrichHighLow = "Price (high to low)";
		String sortPrichLowHigh = "Price (high to low)";

		log.info("Select sort from drop down with "+ sortPrichHighLow);
		inventoryPage.selectItemInDropdown(sortPrichHighLow);
		log.info("Compare the price after sort is equal");
		verifyTrue(inventoryPage.isProductPriceSortDescending());

		log.info("Select sort from drop down with "+ sortPrichLowHigh);
		inventoryPage.selectItemInDropdown(sortPrichLowHigh);

		log.info("Compare the price after sort is equal");
		verifyTrue(inventoryPage.isProductPriceSortDescending());
	}

	@AfterTest
	public void afterTest(){
		driver.quit();
	}

}
