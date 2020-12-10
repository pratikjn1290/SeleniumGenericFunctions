package seleniumGenericfunctions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement doGetElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		doGetElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		doGetElement(locator).click();
	}

	public int getElementCount(String tagName) {
		return driver.findElements(By.tagName(tagName)).size();
	}

	public List<String> doGetAttributes(String tagName, String attributeName) {

		List<WebElement> allElements = driver.findElements(By.tagName(tagName));
		List<String> attirbuteList = new ArrayList<String>();

		for (WebElement elem : allElements) {
			String attributes = elem.getAttribute(attributeName);
			attirbuteList.add(attributes);
		}

		return attirbuteList;
	}

	public void doClickFromList(By locator, String linkText) {

		List<WebElement> allElements = doGetElements(locator);
		for (int i = 0; i < allElements.size(); ++i) {
			String elemText = allElements.get(i).getText();
			if (elemText.equalsIgnoreCase(linkText))
				allElements.get(i).click();
			break;
		}
	}

	// ***************************************Dropdown
	// Utils*********************************************************************

	public void doSelectValueByVisibleText(By locator, String text) {

		Select select = new Select(doGetElement(locator));
		select.selectByVisibleText(text);

	}

	public void doSelectValueByIndex(By locator, int index) {

		Select select = new Select(doGetElement(locator));
		select.selectByIndex(index);

	}

	public void doSelectByValue(By locator, String value) {

		Select select = new Select(doGetElement(locator));
		select.selectByValue(value);

	}

	public ArrayList<String> doGetoptionList(By locator) {
		ArrayList<String> optionText = new ArrayList<String>();
		Select select = new Select(doGetElement(locator));
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			optionText.add(option.getText());
		}

		return optionText;
	}

	public void selectDropDownValueWithoutSelectClass(By locator, String value) {
		List<WebElement> optionsList = doGetElements(locator);
		for (WebElement option : optionsList) {

			String text = option.getText();
			if (text.equals(value))
				option.click();
			break;
		}
	}
}