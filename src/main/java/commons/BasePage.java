package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;

public class BasePage {

	public By getByXpath(String locator){
		return By.xpath(locator);
	}
	public WebElement getElement(WebDriver driver, String locator){
		return driver.findElement(getByXpath(locator));
	}

	public String getElementText(WebDriver driver, String locator){
		return getElement(driver,locator).getText();
	}

	public String getDynamicLocator(String locator, String...params){
		return String.format(locator, (Object[]) params);
	}


	public void clickToElement(WebDriver driver, String locator){
		getElement(driver,locator).click();
	}
	public void clickToElement(WebDriver driver, String locator, String...params){
		locator =getDynamicLocator(locator, params);
		getElement(driver,locator).click();
	}

	public void sendKeyToElement(WebDriver driver,String locator,String value){
		getElement(driver,locator).clear();
		getElement(driver,locator).sendKeys(value);
	}
	public void sendKeyToElement(WebDriver driver,String locator,String value,String...params){
		locator = getDynamicLocator(locator,params);
		getElement(driver,locator).clear();
		getElement(driver,locator).sendKeys(value);
	}



	public void waitForElementVisible(WebDriver driver, String locator){
		explicitWait = new WebDriverWait(driver,longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	public void waitForElementVisible(WebDriver driver, String locator,String...params){
		locator = getDynamicLocator(locator,params);
		explicitWait = new WebDriverWait(driver,longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator){
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public void waitForElementClickable(WebDriver driver, String locator,String...params){
		locator = getDynamicLocator(locator,params);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}


	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		System.out.println("Start time = " + new Date().toString());
//		overrideGlobalTimeput(driver, shortTimeout);
		List<WebElement> elements = getElements(driver, locator);
//		overrideGlobalTimeput(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("Start time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/ displayed on UI");
			System.out.println("Start time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element is DOM is visible on UI");
			return false;
		}
	}


	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private WebDriverWait explicitWait;
//	private long shortTimeout = 5;
	private long longTimeout =15;
	private Select select;

}
