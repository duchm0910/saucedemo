package pageObjects;

import commons.BasePage;
import commons.PageGenerateManager;
import org.openqa.selenium.WebDriver;

import pageUIs.LoginUI;

public class LoginPO extends BasePage {
	WebDriver driver;
	public LoginPO(WebDriver driver){
		this.driver = driver;
	}

	/**
	 * Input value to User Name field
	 * @param driver
	 * @param userName input the value
	 */
	public void sendKeyToUserNameField(WebDriver driver, String userName){
		waitForElementVisible(driver, LoginUI.USERNAME_TEXTBOX);
		sendKeyToElement(driver,LoginUI.USERNAME_TEXTBOX,userName);
	}
	/**
	 * Input value to Password field
	 * @param driver
	 * @param password input the value
	 */
	public void sendKeyToPasswordField(WebDriver driver, String password){
		waitForElementVisible(driver, LoginUI.PWD_TEXTBOX);
		sendKeyToElement(driver,LoginUI.PWD_TEXTBOX,password);
	}

	/**
	 * Click to Login button
	 * @param driver
	 * @return the initialization object for Inventory page
	 */
	public InventoryPO clickToLoginButton(WebDriver driver){
		waitForElementClickable(driver,LoginUI.LOGIN_BTN);
		clickToElement(driver,LoginUI.LOGIN_BTN);
		return PageGenerateManager.getInventoryPage(driver);
	}

	/**
	 * Input User Name and Password then click Login button
	 * @param driver
	 * @param userName value in field user Name
	 * @param password value in field password
	 * @return the initialization object for Inventory page
	 */
	public InventoryPO logintoSystem(WebDriver driver, String userName, String password){
		sendKeyToUserNameField(driver, userName);
		sendKeyToPasswordField(driver, password);
		clickToLoginButton(driver);
		return PageGenerateManager.getInventoryPage(driver);
	}

	/**
	 * get Error Text
	 * @param driver
	 * @return the error text
	 */
	public String getErrorText(WebDriver driver ){
		return getElementText(driver,LoginUI.ERROR_MSG);
	}


}
