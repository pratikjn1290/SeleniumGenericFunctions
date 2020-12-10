package seleniumGenericfunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithOptions {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement multiplevalue = driver.findElement(By.xpath("//input[@id = 'justAnInputBox']"));
		multiplevalue.click();
		Thread.sleep(3000L);

		By combobox = By.xpath("//span[@class = 'comboTreeItemTitle']");
		// doSelectvalue(combobox, "choice 6");
		doSelectmultiplevalue(combobox, "All");
		// doSelectmultiplevalue(combobox, "choice 6 2 1", "choice 6 2 2", "choice 6 2
		// 3");

		driver.close();
	}

	// Multiple select without string array

	public static void doSelectvalue(By locator, String value) {

		List<WebElement> choiceValue = driver.findElements(locator);
		System.out.println(choiceValue.size());

		for (int i = 0; i < choiceValue.size(); i++) {
			String text = choiceValue.get(i).getText();

			if (text.equals(value)) {
				choiceValue.get(i).click();
				break;
			}
		}
	}

	public static void doSelectmultiplevalue(By locator, String... value) {

		List<WebElement> choiceValue = driver.findElements(locator);
		System.out.println(choiceValue.size());

		if (!value[0].equalsIgnoreCase("All")) {
			for (int i = 0; i < choiceValue.size(); i++) {
				String text = choiceValue.get(i).getText();

				for (int j = 0; j < value.length; j++) {

					if (text.equals(value[j])) {
						choiceValue.get(i).click();
						break;
					}
				}

			}
		}

		else {
			for (WebElement allSelection : choiceValue) {
				allSelection.click();
			}
		}
	}
}
