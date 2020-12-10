package seleniumGenericfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownwithSelect {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		By select_noOfEmployee = By.xpath("//select[@id = 'Form_submitForm_NoOfEmployees']");
		ArrayList<String> noOfEmployee = doGetoptionList(select_noOfEmployee);
		System.out.println(noOfEmployee);
		

		// Select oselect = new Select(doGetElement(select_noOfEmployee));

		// oselect.selectByVisibleText("0 - 10");
		// oselect.selectByValue("0 - 10");
		// oselect.selectByIndex(4);

		Thread.sleep(3000L);

		// List<WebElement> options = oselect.getAllSelectedOptions();
		// for (WebElement option : options) {
		// System.out.println(option.getText());
//		}
	}

	public static WebElement doGetElement(By locator) {
		return driver.findElement(locator);
	}

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

	public static ArrayList<String> doGetoptionList(By locator) {
		ArrayList<String> optionText = new ArrayList<String>();
		Select select = new Select(doGetElement(locator));
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			optionText.add(option.getText());
		}

		return optionText;
	}

}
