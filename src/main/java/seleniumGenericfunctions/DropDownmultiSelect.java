package seleniumGenericfunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownmultiSelect {

	static WebDriver driver;

	public static void main(String[] args) {

		By SingleSelection = By.xpath("//input[@id = 'justAnotherInputBox']");
		doGetElement(SingleSelection);

	}

	public static void launch_Browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		driver.close();
	}

	public static WebElement doGetElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public static void dosingleSelection(By locator, String value) {

		List<WebElement> choiceValue = doGetElements(locator);
		for (WebElement choicElement : choiceValue) {
			String text = choicElement.getText();

			if (text.equalsIgnoreCase(value)) {
				choicElement.click();

			}
		}

	}

	public static void doMultipleSelection(By locator, String[] value) {

		List<WebElement> choicesList = doGetElements(locator);

		for (int i = 0; i < choicesList.size(); i++) {
			String textValues = choicesList.get(i).getText();

			for (int j = 0; j < value.length; j++) {
				if (textValues.equals(value[j])) {
					choicesList.get(i).click();
					break;
				}
			}
		}
	}

}