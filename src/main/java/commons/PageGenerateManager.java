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
		if(loginPage == null){
			loginPage = new LoginPO(driver);
		}
		return loginPage;
	}

	public static InventoryPO getInventoryPage(WebDriver driver)   {
		if(inventoryPage == null){
			inventoryPage = new InventoryPO(driver);
		}
		return inventoryPage;
	}

	public static CartPO getCartPage(WebDriver driver){
		if(cardPage == null){
			cardPage = new CartPO(driver);
		}
		return cardPage;
	}
}
