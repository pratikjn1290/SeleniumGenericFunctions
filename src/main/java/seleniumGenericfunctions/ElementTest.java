package seleniumGenericfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(3000L);

		By username = By.xpath("//input[@id = 'username']");
		By password = By.xpath("//input[@id = 'password']");
		By login = By.xpath("//button[@id ='loginBtn']");

		doSendKeys(username, "test@gmail.com");
		doSendKeys(password, "qa@1234");
		doClick(login);

		Thread.sleep(3000L);

		driver.close();

		driver.manage().window().maximize();

	}

	public static WebElement doGetElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		doGetElement(locator).sendKeys(value);
	}

	public static void doClick(By locator) {
		doGetElement(locator).click();
	}

}
