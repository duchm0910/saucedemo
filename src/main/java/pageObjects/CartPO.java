package pageObjects;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageUIs.CartUI;

public class CartPO extends BasePage {
	WebDriver driver;

	public CartPO(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * User Enter the Check out information for field Fisrt Name, Last Name, Postal Code
	 *
	 * @param driver
	 * @param firstName  value for field first name
	 * @param lastName   value for field last name
	 * @param postalCode value for field postal code
	 */
	public void inputCheckOutInformation(WebDriver driver, String firstName, String lastName, String postalCode) {
		//		Wait for firstname field  visible
		waitForElementVisible(driver, CartUI.FIRST_NAME_TEXTBOX);
		//		input value to field First Name
		sendKeyToElement(driver, CartUI.FIRST_NAME_TEXTBOX, firstName);
		//		Wait for lastname field  visible
		waitForElementVisible(driver, CartUI.LAST_NAME_TEXTBOX);
		//		input value to field Last Name
		sendKeyToElement(driver, CartUI.LAST_NAME_TEXTBOX, lastName);
		//		Wait for postal code field  visible
		waitForElementVisible(driver, CartUI.POSTAL_CODE_TEXTBOX);
		//		input value to field Postal Code
		sendKeyToElement(driver, CartUI.POSTAL_CODE_TEXTBOX, postalCode);
	}

	/**
	 * Click to the Button in Cart - Process Step
	 *
	 * @param action input name of action button
	 */
	public void clickActionButton(String action) {
		//		Wait for button displayed
		waitForElementClickable(driver, CartUI.ACTION_BTN, action);
//		Click to the button in cart
		clickToElement(driver, CartUI.ACTION_BTN, action);
	}

	/**
	 * Click to the Button in Cart - Only for Continue button
	 */
	public void clickContinueButton() {
		//		Wait for button displayed
		waitForElementClickable(driver, CartUI.CONTINUE_BTN);
		//		Click to the Continue button in cart
		clickToElement(driver, CartUI.CONTINUE_BTN);
	}

	/**
	 *  Get the title text
	 * @return the Text title
	 */
	public String getTitleText() {
		waitForElementVisible(driver, CartUI.STEP_TITLE);
		return getElementText(driver, CartUI.STEP_TITLE);
	}

	/**
	 * Get the Produce name
	 * @return product name in cart
	 */
	public String getItemInCartText() {
//		wait for the product name visible
		waitForElementVisible(driver, CartUI.PRODUCT_NAME_TEXT);
//		return the product name text
		return getElementText(driver, CartUI.PRODUCT_NAME_TEXT);
	}
}
