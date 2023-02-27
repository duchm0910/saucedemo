package pageObjects;

import commons.BasePage;
import commons.PageGenerateManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.InventoryUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPO extends BasePage {
	WebDriver driver;

	public InventoryPO(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Get text of product title
	 *
	 * @param driver
	 * @return the product title text
	 */
	public String getProducTitle(WebDriver driver) {
		return getElementText(driver, InventoryUI.PRODUCT_TITLE);
	}



	/**
	 * Select the dropdown item
	 *
	 * @param itemText item want to selected
	 */
	public void selectItemInDropdown(String itemText) {
		waitForElementClickable(driver, InventoryUI.SORT_DROPDOWN);
		selectDropdownByText(driver, InventoryUI.SORT_DROPDOWN, itemText);
	}


	/**
	 * Get List Text of product name then using sort in library Collestion then check the equal(Boolean)
	 * Sort the produc Ascending and compare by Product Name
	 *
	 * @return true/false the all product name before compare after sort
	 */
	public boolean isProductNameSortAscending() {
		List<WebElement> productNameElements = getElements(driver, InventoryUI.PRODUCT_NAME_TEXT);

		List<String> productNameText = new ArrayList<String>();

		for (WebElement productName : productNameElements) {
			System.out.println(productName.getText());
			productNameText.add(productName.getText());
		}
		System.out.println("Before sort Ascending:--------------------");
		for (String product : productNameText) {
			System.out.println(product);
		}
		System.out.println("\n");

		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);

		System.out.println("After sort Ascending:--------------------");
		for (String product : productNameTextClone) {
			System.out.println(product);
		}
		System.out.println("\n");

		return productNameText.equals(productNameTextClone);
	}

	/**
	 * Get List Text of product name then using sort in library Collestion then check the equal(Boolean)
	 * Sort the produc Descending and compare by Product Name
	 *
	 * @return true/false the all product name before compare after sort
	 */
	public boolean isProductNameSortDescending() {
		List<WebElement> productNameElements = getElements(driver, InventoryUI.PRODUCT_NAME_TEXT);

		List<String> productNameText = new ArrayList<String>();

		for (WebElement productName : productNameElements) {
			productNameText.add(productName.getText());
		}
		System.out.println("Before sort Descending:--------------------");
		for (String product : productNameText) {
			System.out.println(product);
		}
		System.out.println("\n");

		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		Collections.reverse(productNameTextClone);

		System.out.println("After sort Descending:--------------------");
		for (String product : productNameTextClone) {
			System.out.println(product);
		}
		System.out.println("\n");

		return productNameText.equals(productNameTextClone);
	}

	/**
	 * Get List Text of price then using sort in library Collestion then check the equal(Boolean)
	 * Sort the product Ascending and compare by Product Price
	 *
	 * @return true/false the all product price before compare after sort
	 */
	public boolean isProductPriceSortAscending() {
		List<WebElement> productPriceElements = getElements(driver, InventoryUI.PRODUCT_PRICE_TEXT);

		List<Float> productNamePrice = new ArrayList<Float>();

		for (WebElement productPrice : productPriceElements) {
			float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$", ""));
			productNamePrice.add(productPriceNumber);
		}
		System.out.println("Before sort Ascending:--------------------");
		for (Float productPrice : productNamePrice) {
			System.out.println(productPrice);
		}
		System.out.println("\n");

		List<Float> productNamePriceClone = new ArrayList<Float>(productNamePrice);
		Collections.sort(productNamePriceClone);

		System.out.println("After sort Ascending:--------------------");
		for (Float productPrice : productNamePriceClone) {
			System.out.println(productPrice);
		}
		System.out.println("\n");

		return productNamePrice.equals(productNamePriceClone);
	}

	/**
	 * Get List Text of price then using sort in library Collestion then check the equal(Boolean)
	 * Sort the product Descending and compare by Product Price
	 *
	 * @return true/false the all product price before compare after sort
	 */
	public boolean isProductPriceSortDescending() {
		List<WebElement> productPriceElements = getElements(driver, InventoryUI.PRODUCT_PRICE_TEXT);

		List<Float> productNamePrice = new ArrayList<Float>();

		for (WebElement productPrice : productPriceElements) {
			float productPriceNumber = Float.parseFloat(productPrice.getText().replace("$", ""));
			productNamePrice.add(productPriceNumber);
		}
		System.out.println("Before sort Ascending:--------------------");
		for (Float productPrice : productNamePrice) {
			System.out.println(productPrice);
		}
		System.out.println("\n");

		List<Float> productNamePriceClone = new ArrayList<Float>(productNamePrice);
		Collections.sort(productNamePriceClone);
		Collections.reverse(productNamePriceClone);

		System.out.println("After sort Ascending:--------------------");
		for (Float productPrice : productNamePriceClone) {
			System.out.println(productPrice);
		}
		System.out.println("\n");

		return productNamePrice.equals(productNamePriceClone);
	}

	/**
	 * Click to the Add To Cart button
	 *
	 * @param productName the name of item want to add
	 */
	public void clickAddToCart(String... productName) {
		waitForElementVisible(driver, InventoryUI.ADD_TO_CART_BTN, productName);
		clickToElement(driver, InventoryUI.ADD_TO_CART_BTN, productName);
	}

	/**
	 * Get the number of cart quantity
	 *
	 * @return Text at Cart quantity button
	 */
	public String getCartQty() {
		waitForElementVisible(driver, InventoryUI.CART_QUANTITY_BTN);
		return getElementText(driver, InventoryUI.CART_QUANTITY_BTN);
	}

	/**
	 * Check the true/false cart quantity displayed
	 *
	 * @param driver
	 * @return Cart Quantity is displayed or not
	 */
	public boolean isCartQtyDisplayed(WebDriver driver) {
		return isElementUndisplayed(driver, InventoryUI.CART_QUANTITY_BTN);
	}

	/**
	 * Click to Cart button
	 *
	 * @return the initialization object for cart page
	 */
	public CartPO clickCartButton() {
//	wait for the Cart button visible
		waitForElementVisible(driver, InventoryUI.CART_BTN);
//		Click on the Cart buttons
		clickToElement(driver, InventoryUI.CART_BTN);
//		return the initialization object for cart page
		return PageGenerateManager.getCartPage(driver);
	}


}
