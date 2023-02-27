package pageUIs;

public class InventoryUI {
	public static final String PRODUCT_TITLE = "//span[@class='title']";
	public static final String SORT_DROPDOWN = "//select[@class='product_sort_container']";
	public static final String PRODUCT_NAME_TEXT = "//div[@class='inventory_item_name']";
	public static final String PRODUCT_PRICE_TEXT = "//div[@class='inventory_item_price']";

	public static final String ADD_TO_CART_BTN = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";
	public static final String CART_BTN = "//a[@class='shopping_cart_link']";
	public static final String CART_QUANTITY_BTN = "//span[@class='shopping_cart_badge']";
}
