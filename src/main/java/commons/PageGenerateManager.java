package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.CartPO;
import pageObjects.InventoryPO;
import pageObjects.LoginPO;

public class PageGenerateManager {
	private static LoginPO loginPage;
	private static InventoryPO inventoryPage;
	private static CartPO cardPage;

	private PageGenerateManager(){

	}

	public static LoginPO getLoginPage(WebDriver driver){
			return loginPage = new LoginPO(driver);
	}

	public static InventoryPO getInventoryPage(WebDriver driver)   {
			return inventoryPage = new InventoryPO(driver);
	}

	public static CartPO getCartPage(WebDriver driver){
			return cardPage = new CartPO(driver);

	}
}
