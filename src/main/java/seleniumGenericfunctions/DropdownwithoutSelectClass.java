package seleniumGenericfunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownwithoutSelectClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		By industry = By.xpath("//select[@id = 'Form_submitForm_Industry']/option");
		selectDropDownValueWithoutSelectClass(industry, "Aerospace");

		System.out.println("Value is selected now waiting");
		Thread.sleep(6000L);
	
	}
	

	public static void selectDropDownValueWithoutSelectClass(By locator, String value) {
		List<WebElement> industry_List = driver.findElements(locator);
		for (WebElement industry : industry_List) {

			String text = industry.getText();
			if (text.equals(value))
			{
				industry.click();
				break;
			}
		}

	}

}
