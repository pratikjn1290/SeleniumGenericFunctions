package seleniumGenericfunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllOptions {

	static WebDriver driver;

	public static void main(String args[]) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement elem = driver.findElement(By.xpath("//select[@name = 'country']"));
		Select oselect = new Select(elem);

		List<WebElement> country = oselect.getOptions();

		for (WebElement city : country) {
			String city_name = city.getText();
			if (city_name.equalsIgnoreCase("ANDORRA")) {
				city.click();
				System.out.println("City Selected");
				Thread.sleep(3000L);
			}
		}

	}

}