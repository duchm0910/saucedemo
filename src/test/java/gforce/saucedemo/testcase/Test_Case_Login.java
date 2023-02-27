package gforce.saucedemo.testcase;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.InventoryPO;
import pageObjects.LoginPO;

public class Test_Case_Login extends BaseTest {
	WebDriver driver;
	LoginPO loginPage;
	InventoryPO inventoryPage;

	String username = "standard_user";
	String password = "secret_sauce";

	@Parameters({"browser","url"})
	@BeforeTest
	public void initBrowserDriver(String browser, String url){
		log.info("Pre condition: Open Browser: " + browser + "and navigate to url:" + url);
		driver = getBrowserDriver(browser,url);
	}
	@Test(priority = 1)
	public void Invalid_User_Name_Password_Login(){
		String invalidUserName = "invalid";
		String invalidPwd = "123456";
		loginPage = new LoginPO(driver);

		log.info("Send key to User Name field");
		loginPage.sendKeyToUserNameField(driver,invalidUserName);

		log.info("Send key to Password field");
		loginPage.sendKeyToPasswordField(driver,invalidPwd);

		log.info("Click to Login button");
		loginPage.clickToLoginButton(driver);

		log.info("Verify login success through home page title");
		String actualErrorMsg = loginPage.getErrorText(driver);
		String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
		verifyEquals(actualErrorMsg,expectedErrorMsg);
	}

	@Test(priority = 2)
	public void Invalid_User_Name_And_Valid_Password_Login(){
		String invalidUserName = "invalid";
		String validPwd = "secret_sauce";
		loginPage = new LoginPO(driver);

		log.info("Send key to User Name field");
		loginPage.sendKeyToUserNameField(driver,invalidUserName);

		log.info("Send key to Password field");
		loginPage.sendKeyToPasswordField(driver,validPwd);

		log.info("Click to Login button");
		loginPage.clickToLoginButton(driver);

		log.info("Verify error message when input Invalid username and valid password");
		String actualErrorMsg = loginPage.getErrorText(driver);
		String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
		verifyEquals(actualErrorMsg,expectedErrorMsg);
	}

	@Test(priority = 3)
	public void Valid_User_Name_And_Invalid_Password_Login(){
		String validUserName = "standard_user";
		String invalidPwd = "123456";
		loginPage = new LoginPO(driver);

		log.info("Send key to User Name field");
		loginPage.sendKeyToUserNameField(driver,validUserName);

		log.info("Send key to Password field");
		loginPage.sendKeyToPasswordField(driver,invalidPwd);

		log.info("Click to Login button");
		loginPage.clickToLoginButton(driver);

		log.info("Verify error message when input Valid username and Invalid password");
		String actualErrorMsg = loginPage.getErrorText(driver);
		String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
		verifyEquals(actualErrorMsg,expectedErrorMsg);
	}

	@Test(priority = 4)
	public void Valid_Login(){
		loginPage = new LoginPO(driver);

		log.info("Send key to User Name field");
		loginPage.sendKeyToUserNameField(driver,username);

		log.info("Send key to Password field");
		loginPage.sendKeyToPasswordField(driver,password);

		log.info("Click to Login button");
		inventoryPage = loginPage.clickToLoginButton(driver);

		log.info("Verify login success through home page title");
		String actualTitle = inventoryPage.getProducTitle(driver);
		String expectedTitle = "PRODUCTS";
		verifyEquals(actualTitle,expectedTitle);
	}



}
